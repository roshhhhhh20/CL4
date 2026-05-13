package titanic;
import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class SurvivorMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text pclass = new Text();
    private final static IntWritable one = new IntWritable(1);

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();

        if (line.startsWith("PassengerId")) return;

        String[] str = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        if (str.length > 2 && str[1].equals("0")) {

            pclass.set("Class_" + str[2]);
            context.write(pclass, one);
        }
    }
}
