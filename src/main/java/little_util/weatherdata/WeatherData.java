package little_util.weatherdata;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.File;
import java.io.IOException;

public class WeatherData {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {


        File file = new File("/Users/liwang/Desktop/test/weatherdata/data");
        File[] array = file.listFiles();
        String inputPath, outputPath;
        System.out.println("Result saved in ./weaherdata/result: ahahaha");
        for (File file1 : array) {
            inputPath = "./weatherdata/data/" + file1.getName();
            outputPath = "./weatherdata/result/" + file1.getName();
            System.out.println(outputPath.substring(21));
            Job job = Job.getInstance(new Configuration());

            job.setJarByClass(WeatherData.class);
            job.setMapperClass(WeatherDataMapper.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(DoubleWritable.class);
            job.setReducerClass(WeatherDataReducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(DoubleWritable.class);
            FileInputFormat.setInputPaths(job, new Path(inputPath));
            FileOutputFormat.setOutputPath(job, new Path(outputPath));
            job.waitForCompletion(false);
        }
    }
}
