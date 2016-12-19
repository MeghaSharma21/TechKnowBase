package javatools.parsers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class RefiningListsUsingYagoTypes
{
	public static void main(String[] argv) throws Exception {    
		  BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Megha Sharma\\Downloads\\yagoSimpleTypes.tsv"));
		  BufferedReader br1=new BufferedReader(new FileReader("C:\\Users\\Megha Sharma\\Desktop\\MergedListOfTC"));
		  File file = new File("C:\\Users\\Megha Sharma\\Desktop\\Temp_Simple");
	      file.createNewFile();
	      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
String line,line1;

List<String> TConcepts = new ArrayList<String>();
while((line1=br1.readLine())!=null)
{	line1=line1.toLowerCase();
line1=line1.replaceAll("_", " ");
	TConcepts.add(line1);
}

while((line=br.readLine())!=null)
{
	if(line.contains("rdf:type"))
	{
		line=line.replaceAll("[<>]", "");
		line=line.replaceAll("_", " ");
		String[] temp;
		temp=line.split("\t");
		if(TConcepts.contains(temp[1]))
		{
			writer.write(line+"\n");
		}
				
	}
}





	br.close();
	writer.close();
}
}
