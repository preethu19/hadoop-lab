package temp;
import java.io.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;


public class mapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException{
		String s=value.toString();
		String s1=s.substring(15, 19);
		int temperature;
		if(s.charAt(87)=='+'){
			temperature=Integer.parseInt(s.substring(88,92));
		} else{
			temperature=Integer.parseInt(s.substring(87,92));
		}
		con.write(new Text(s1), new IntWritable(temperature));
	}

}
