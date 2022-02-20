package temp;
import java.io.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;


public class mapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException{
		String[] line = value.toString().split(" ");
		for(String num: line){
			int number = Integer.parseInt(num);
			if(number%2==1){
				con.write(new Text("ODD"), new IntWritable(number));
			}
			else{
				con.write(new Text("EVEN"), new IntWritable(number));
			}
		}
	}
}
