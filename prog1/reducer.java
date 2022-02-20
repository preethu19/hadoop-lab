package temp;
import java.io.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;


public class reducer extends Reducer<Text,IntWritable,Text,IntWritable>{
		public void reduce(Text key, Iterable<IntWritable> values, Context con) throws IOException, InterruptedException {
			int maxvalue=Integer.MIN_VALUE;
			int minvalue=Integer.MAX_VALUE;
			for(IntWritable value:values){
				maxvalue = Math.max(maxvalue, value.get());
				minvalue = Math.min(minvalue, value.get());
			}
			con.write(key, new IntWritable(maxvalue));
			con.write(key, new IntWritable(minvalue));
	}
		
	

}
