package titanic;
import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class AvgAgeMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text gender = new Text();
    private IntWritable age = new IntWritable();

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();

        if (line.startsWith("PassengerId")) return;

        String[] str = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        if (str.length > 5 && str[1].equals("1")) {

            if (!str[5].isEmpty()) {
                try {
                    int ageVal = (int) Float.parseFloat(str[5]);

                    gender.set(str[4]);
                    age.set(ageVal);

                    context.write(gender, age);
                } catch (Exception e) {}
            }
        }
    }
}
