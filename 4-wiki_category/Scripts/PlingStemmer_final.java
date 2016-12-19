 public static void main(String[] argv) throws Exception {    
	  BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Megha Sharma\\Desktop\\MergedListOfTC"));
	  BufferedReader br1=new BufferedReader(new FileReader("C:\\Users\\Megha Sharma\\Downloads\\categoryAndTheirSubacteories"));
	  File file = new File("C:\\Users\\Megha Sharma\\Desktop\\SubClassOf");
      file.createNewFile();
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      File file1 = new File("C:\\Users\\Megha Sharma\\Desktop\\SubFieldOf");
      file1.createNewFile();
      BufferedWriter writer1 = new BufferedWriter(new FileWriter(file1));
	  
	  
	 String line,line1,a,b,c,d,e;
    List<String> TConcepts = new ArrayList<String>();
    while((line=br.readLine())!=null)
    {	line=line.toLowerCase();
    line=line.replaceAll("_", " ");
    	TConcepts.add(line);
    }
      while((line1=br1.readLine())!=null)
      {	  line1=line1.toLowerCase();
    	line1=line1.replaceAll("\\p{P}\\p{S}", "");
    	line1=line1.replaceAll("_", " ");
    	 StringTokenizer st=new StringTokenizer(line1,"\t");
    	 if(st.countTokens()==2)
    	 {
    		if(TConcepts.contains(a=st.nextToken()))
    		{
    			if(TConcepts.contains( b=st.nextToken()))
    			{
    				if(a.contains(" "))
    				d=a.substring(a.lastIndexOf(" ")+1);
    				else
    					d=a;
    				if(b.contains(" "))
    				e=b.substring(b.lastIndexOf(" ")+1);
    				else
    					e=b;
    				if(d.equals(e)||d.equals(stem(e))||(stem(d)).equals(e))
    					writer.write(b+",SubClassOf,"+a+"\n");
    				else
    					writer1.write(b+",SubFieldOf,"+a+"\n");

    			}
    				
    		}
    	 }
    	 
      }
      br.close();
      br1.close();
      writer.close();
      writer1.close();
}

    	