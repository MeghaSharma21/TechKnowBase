// removing relations which are not required like 'see also' etc.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ExtractingTriplesFromTemplates
{

	public static void main(String[] argv) throws Exception {    
		  BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Megha Sharma\\Downloads\\formattedTriplesLatest"));
		  BufferedReader br1=new BufferedReader(new FileReader("C:\\Users\\Megha Sharma\\Desktop\\MergedList_TC"));
		  File file = new File("C:\\Users\\Megha Sharma\\Desktop\\SievedTemplates1");
	      file.createNewFile();
	      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
String line,line1,temp[];

List<String> TConcepts = new ArrayList<String>();
while((line1=br1.readLine())!=null)
{	line1=line1.toLowerCase();
line1=line1.replaceAll("_", " ");
	TConcepts.add(line1);
}
String[] a,b;
while((line=br.readLine())!=null)
{
	line=line.toLowerCase();
	line=line.replaceAll("_", " ");
	 temp=line.split("\t");
	
	 if(TConcepts.contains(temp[0])&&(temp.length>2))
	 {		if(temp[1].contains("@@@@@"))
		 	temp[1]=temp[1].replaceAll("@@@@@","/");
	 if(temp[2].contains("@@@@@"))
		 	temp[2]=temp[2].replaceAll("@@@@@","/");
		 if(line.contains("see also")||line.contains("{{navbox")||line.contains("others")||line.contains("related topics")||line.contains("authority control")||line.contains("related fields")||line.contains("other"))
		 {
			 continue;
		 }
		 else
		 {	writer.write(temp[0]+";"+temp[1]+";"+temp[2]+"\n");
			 //String[] arr=line.split("\t");
			 /*if(arr.length>2)
			 {if(arr[1].contains("@@@@@"))
			 {
				a=arr[1].split("@@@@@");
				if(arr[2].contains("@@@@@"))
				{
					b=arr[2].split("@@@@@");
					writer.write(arr[0]+"\t"+a[0]+"\t"+b[0]+"\n");
					writer.write(arr[0]+"\t"+a[0]+"\t"+b[1]+"\n");
					writer.write(arr[0]+"\t"+a[1]+"\t"+b[0]+"\n");
					writer.write(arr[0]+"\t"+a[1]+"\t"+b[1]+"\n");
				}
				else
				{
					writer.write(arr[0]+"\t"+a[0]+"\t"+arr[2]+"\n");
					writer.write(arr[0]+"\t"+a[1]+"\t"+arr[2]+"\n");
				}
					
			 }
			 else
			 {
				 
				 if(arr[2].contains("@@@@@"))
					{
						b=arr[2].split("@@@@@");
						writer.write(arr[0]+"\t"+arr[1]+"\t"+b[0]+"\n");
						writer.write(arr[0]+"\t"+arr[1]+"\t"+b[1]+"\n");
						
					}
					else
					{
						writer.write(arr[0]+"\t"+arr[0]+"\t"+arr[2]+"\n");
						
					}
						
			 }
			 
		 } */
				
}
}

}



	br.close();
	writer.close();
}
}
