package com.open.weatherdata;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WeatherDataMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] tokens = value.toString().split(",");
        if (tokens.length != 3)
            return;

        Text date = new Text(tokens[1].substring(1, 8));
        DoubleWritable temp = new DoubleWritable(Double.valueOf(tokens[2]));
        context.write(date, temp);
    }

}
