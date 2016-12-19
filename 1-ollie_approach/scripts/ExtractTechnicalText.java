/* Author: Prajna Upadhyay
 * Input
 * 	1) list of technical concepts
 *  2) text extracted from entire mediawiki dump using WikiExtractor.py
 * Output
 *  1) a single text file containing the text from the Wikipedia pages of the concepts specified in the input list
 * */

import java.util.HashMap;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class ExtractTechnicalText 
{
	void filterTechnicalContent(String filename, BufferedWriter bw, ArrayList<String> techConceptsList) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		String pattern1 = "<doc id=(.*) title=\"(.*)\"";
		String pattern2 = "</doc>";
		boolean flag = false;
		boolean include = false;
		boolean startConcept = false;
		while((line=br.readLine())!=null)
		{
			if(matchPattern(line, pattern1)==true && flag==false)
			{
				flag=true;
				startConcept=true;
				String conceptName = getTitle(line, pattern1).replace(" ","_").toLowerCase();
				if(techConceptsList.contains(conceptName))
				{
					include = true;
				}
			}
			else if(matchPattern(line, pattern2)==true && flag==true)
			{
				flag=false;
				include = false;
				bw.write("\n");
			}
			else if(matchPattern(line, pattern1)==false && matchPattern(line, pattern2)==false && flag==true && include==true && startConcept==true)
			{	
					bw.write(line+"\t");
					startConcept=false;
			}
			else if(matchPattern(line, pattern1)==false && matchPattern(line, pattern2)==false && flag==true && include==true && startConcept==false)
			{	
					bw.write(line+" ");
					startConcept=false;
			}
		}
		br.close();
	}
	
	public boolean matchPattern(String line, String pattern)
	{
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (m.find()) 
		{
	         return true;
	     } 
		else 
		{
	         return false;
	    }
	}
	
	public String getTitle(String line, String pattern)
	{
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (m.find()) 
		{
	         return m.group(2);
	     } 
		else 
		{
	         return null;
	    }
	}
	
	public static void main(String args[]) throws Exception
	{
		ExtractTechnicalText t = new ExtractTechnicalText();
		GetPropertyValues properties = new GetPropertyValues();
		HashMap<String, String> hm = properties.getPropValues();
		String location = hm.get("parsed-files");
		String techConcepts = hm.get("technical-concepts-list");
		ArrayList<String> techConceptsList = new ArrayList<String>();
		File f = new File(techConcepts);
		System.out.println(f.getName());
		BufferedReader br = new BufferedReader(new FileReader(techConcepts));
		String line;
		while((line=br.readLine())!=null)
		{
			techConceptsList.add(line.replace(" ","_").toLowerCase());
		}
		File locationFolder = new File(location);
		String[] names = locationFolder.list();
		BufferedWriter bw = new BufferedWriter(new FileWriter(hm.get("parsed-files")+f.getName()+"_"));
		System.out.println(hm.get("parsed-files")+f.getName()+"_");
		for(String name : names)
		{
			File subFolder = new File(location + name);
		    if (subFolder.isDirectory())
		    {
		    	String[] names1 = subFolder.list();
		    	for(String name1:names1)
		    	{
		    		//File file1 = new File(location + name + "/"+name1);
		    		t.filterTechnicalContent(location + name + "/"+name1, bw, techConceptsList);
		    	}
		    }
		}
		bw.close();
		br.close();
	}
}
