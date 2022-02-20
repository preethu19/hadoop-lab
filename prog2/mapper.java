package temp;
import java.io.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;


public class mapper extends Mapper<LongWritable,Text,Text,DoubleWritable>{
	public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException{
		String[] line = value.toString().split(",", 12);
		if(line.length!=12){
			System.out.println("- " + line.length);
			return;
		}
		String s1 = line[11];
		double s2 = Double.parseDouble(line[8]);
		con.write(new Text(s1), new DoubleWritable(s2));
	}

}
