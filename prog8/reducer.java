package temp;

import java.io.*;
import java.util.HashMap;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class reducer extends Reducer<Text, Text, Text, Text> {
	public void reduce(Text key,Iterable<Text> values,Context con) throws IOException,InterruptedException{
		HashMap<Integer,Float> hashA= new HashMap<Integer,Float>();
		HashMap<Integer,Float> hashB= new HashMap<Integer,Float>();
		float res=0.0f;
		int n=Integer.parseInt(con.getConfiguration().get("n"));
		float a_ij,b_jk;
		for(Text value:values){
			String val=value.toString();
			String dat[]=val.split(",");
			if(dat[0].equals("A")){
				hashA.put(Integer.parseInt(dat[1]),Float.parseFloat(dat[2]));
			}
			else{
				hashB.put(Integer.parseInt(dat[1]),Float.parseFloat(dat[2]));
			}
		}
		for(int j=0;j<n;j++){
			a_ij=hashA.containsKey(j)?hashA.get(j):0.0f;
			b_jk=hashB.containsKey(j)?hashB.get(j):0.0f;
			res+=a_ij*b_jk;
		}
		if(res!=0.0f){
			con.write(null,new Text(key.toString()+","+Float.toString(res)));
		}
	}
}
