package temp;
import java.io.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class driver {
	public static void main(String args[]){
		try{
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(driver.class);
		job.setMapperClass(mapper.class);
		job.setReducerClass(reducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		Path pi = new Path(args[0]);
		Path po = new Path(args[1]);
		FileInputFormat.addInputPath(job, pi);
		FileOutputFormat.setOutputPath(job, po);
		System.exit(job.waitForCompletion(true)?1:0);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
