package temp;
import java.io.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;


public class reducer extends Reducer<Text,DoubleWritable,Text,DoubleWritable>{
		public void reduce(Text key, Iterable<DoubleWritable> values, Context con) throws IOException, InterruptedException {
			double maxvalue=Double.MIN_VALUE;
			double minvalue=Double.MAX_VALUE;
			for(DoubleWritable value:values){
				maxvalue = Math.max(maxvalue, value.get());
				minvalue = Math.min(minvalue, value.get());
			}
			con.write(new Text(key+" Maximum: "), new DoubleWritable(maxvalue));
			con.write(new Text(key+" Minimum: "), new DoubleWritable(minvalue));
	}
		
	

}
