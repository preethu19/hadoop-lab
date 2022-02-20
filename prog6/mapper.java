package temp;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class mapper extends Mapper<LongWritable,Text,Text,DoubleWritable>{
	public void map(LongWritable key,Text value,Context con) throws IOException,InterruptedException{
		String[] line = value.toString().split("\t");
		double salary = Double.parseDouble(line[8]);
		con.write(new Text(line[3]),new DoubleWritable(salary));
	}
}
