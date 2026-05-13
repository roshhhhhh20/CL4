package grader;
import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class GradeMapper extends Mapper<LongWritable, Text, Text, Text> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] data = value.toString().split(" ");

        String name = data[0];
        int marks = Integer.parseInt(data[1]);
        String grade;

        if (marks >= 90)
            grade = "A";
        else if (marks >= 75)
            grade = "B";
        else if (marks >= 50)
            grade = "C";
        else
            grade = "D";

        context.write(new Text(name), new Text(grade));
    }
}
