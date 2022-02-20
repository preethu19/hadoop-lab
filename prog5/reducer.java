package temp;
import java.io.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;


public class reducer extends Reducer<Text,IntWritable,Text,IntWritable>{
		public void reduce(Text key, Iterable<IntWritable> values, Context con) throws IOException, InterruptedException {
			int count = 0, sum = 0;
			for(IntWritable value:values){
				count += 1;
				sum += value.get();
			}
			con.write(key, new IntWritable(sum));
			con.write(key, new IntWritable(count));
	}
}
