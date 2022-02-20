package temp;
import java.io.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class mapper extends Mapper<LongWritable,Text,Text,Text>{
	public void map(LongWritable key,Text value,Context con) throws IOException,InterruptedException{
		String valueString=value.toString();
		String data[] = valueString.split(",");
		Configuration conf = con.getConfiguration();
		int p=Integer.parseInt(conf.get("p"));
		int m=Integer.parseInt(conf.get("m"));
		Text ok=new Text();
		Text ov=new Text();
		if(data[0].equals("A")){
			for(int k=0;k<p;k++){
				ok.set(data[1]+","+k);
				ov.set("A"+","+data[2]+","+data[3]);
				con.write(ok,ov);
			}
		}
		else{
			for(int i=0;i<m;i++){
			ok.set(i+","+data[2]);
			ov.set("B"+","+data[1]+","+data[3]);
			con.write(ok,ov);
			}
		}
	}
}
