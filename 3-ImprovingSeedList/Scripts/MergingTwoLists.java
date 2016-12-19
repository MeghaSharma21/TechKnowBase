//Merges two lists of technical concepts
package javatools.parsers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MergingTwoLists {
	 public static void main(String[] argv) throws Exception {    
		  BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Megha Sharma\\Downloads\\fromServer\\PagesOnlyTechnical"));
		  BufferedReader br1=new BufferedReader(new FileReader("C:\\Users\\Megha Sharma\\Desktop\\petscan_TC_onlyTitles"));
		  File file = new File("C:\\Users\\Megha Sharma\\Desktop\\MergedListOfTC");
	      file.createNewFile();
	      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		  
		 String line,line1,a,b;
	    List<String> TConcepts = new ArrayList<String>();
	    while((line=br.readLine())!=null)
	    {	line=line.toLowerCase();
	    line=line.replaceAll("_", " ");
	    	TConcepts.add(line);
	    }
	    List<String> TConcepts1 = new ArrayList<String>();
	    while((line1=br1.readLine())!=null)
	    {	TConcepts1.add(line1);
	    }
	      
	   for(String line2:TConcepts1)
	   {//System.out.println(line2+" "+TConcepts.contains(line2));
		   	if(TConcepts.contains(line2))
		   		{ 
		   		writer.write(line2+"\n");
		   		}
	   }
	      br.close();
	      br1.close();
	      writer.close();
}

}
