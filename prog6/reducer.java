package temp;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class reducer extends Reducer<Text,DoubleWritable,Text,DoubleWritable>{
        public void reduce(Text key,Iterable<DoubleWritable> values,Context con) throws IOException,InterruptedException{
	double count=0, total=0, avg;
	for(DoubleWritable value:values){
		count += 1;
		total += value.get();
	}
	avg = total/count;
	con.write(key, new DoubleWritable(avg));
	con.write(key, new DoubleWritable(count));
	}
}
