// Cleans the csv file obtained from petscan and transforms into a list of technical concepts
package javatools.parsers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FilteringPetScanInput {

	public static void main(String[] argv) throws Exception {    
		  BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Megha Sharma\\Downloads\\petscan_TC"));
		  File file = new File("C:\\Users\\Megha Sharma\\Desktop\\petscan_TC_onlyTitles");
	      file.createNewFile();
	      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		  String line,a;
		  while((line=br.readLine())!=null)
		  {
			  line=line.toLowerCase();
			  line=line.replaceAll("_"," ");
			  StringTokenizer st=new StringTokenizer(line,"\t");
			  st.nextToken();
			  a=st.nextToken();
			  writer.write(a+"\n");
			  
			  
		  }
		  br.close();
		  writer.close();
	
	}

	
	}
	

