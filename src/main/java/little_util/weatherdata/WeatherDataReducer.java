package little_util.weatherdata;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WeatherDataReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {

    @Override
    protected void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
        double maxTemp = Double.NEGATIVE_INFINITY, minTemp = Double.POSITIVE_INFINITY;

        for (DoubleWritable temp : values) {
            maxTemp = Math.max(maxTemp, temp.get());
            minTemp = Math.min(minTemp, temp.get());
        }

        context.write(new Text(key.toString() + "-MAX"), new DoubleWritable(maxTemp));
        context.write(new Text(key.toString() + "-MIN"), new DoubleWritable(minTemp));
    }

}
