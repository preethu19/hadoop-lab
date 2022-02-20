package temp;
import java.io.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;


public class mapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException{
		String[] line = value.toString().split(",", 18);
		if(line.length!=18){
			System.out.println("- " + line.length);
			return;
		}
		if(line[0].equals("policyID")){
			return;
		}
		String s1 = line[16];
		con.write(new Text(s1), new IntWritable(1));
	}

}
