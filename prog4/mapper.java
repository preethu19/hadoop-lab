package temp;
import java.io.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;


public class mapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException{
		String[] line = value.toString().split(",");
		if(line.length!=12){
			return;
		}
		if(line[0].equals("Transaction_date")){
			return;
		}
		String country = "_country_" + line[7];
		String payment = "_product_" + line[1];
	       	int price = Integer.parseInt(line[2]);
		con.write(new Text(country), new IntWritable(price));	
		con.write(new Text(payment), new IntWritable(1));
	}

}
