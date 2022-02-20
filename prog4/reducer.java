package temp;
import java.io.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;


public class reducer extends Reducer<Text,IntWritable,Text,IntWritable>{
		public void reduce(Text key, Iterable<IntWritable> values, Context con) throws IOException, InterruptedException {
			String k = key.toString();
			if(k.substring(0, 9) == "_country_"){
				int total = 0;
				for(IntWritable value: values){
					total += value.get();
				}
				con.write(key, new IntWritable(total));
			}
			else{
				int count = 0;
				for(IntWritable value:values){
					count += value.get();
				}
				con.write(key, new IntWritable(count));
			}
	}
}
