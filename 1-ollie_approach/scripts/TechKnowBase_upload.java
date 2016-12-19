
//This extracts the triples contacting interesting concepts from all the triples extracted by Ollie.


import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Megha
 */
public class TechKnowBase_upload {

    public static void main(String[] args) throws IOException{
           int x=3,y=1,flag=0,flag1=0,startIndex,endIndex;
         BufferedReader br=new BufferedReader(new FileReader("triples"));
         BufferedReader br1=new BufferedReader(new FileReader("./seeds/commonTagsWikiSoCategories"));
         File file = new File("triplesContainingInterestingConcepts");
         file.createNewFile();
         BufferedWriter writer = new BufferedWriter(new FileWriter(file));
          String line = br.readLine();
         String line1;
          ArrayList<String> TConcepts = new ArrayList<String>();

            while((line1 = br1.readLine()) != null)
            {   line1=line1.toLowerCase();
                line1=line1.replaceAll("\\s+","_");
                TConcepts.add(line1);
            }
          
            while (line != null)
            {   line=line.toLowerCase();
                line=line.replaceAll("\\s+", "_");
                startIndex = line.indexOf("(");
                  if((endIndex = line.indexOf(")"))!=-1)
                  {line=line.substring(startIndex+1, endIndex);}
                  else
                  { line = br.readLine();
                    continue;}
                String[] parts = line.split(";");
                if(parts.length<3)
                    { line = br.readLine();
                      continue;}
                
               //if(TConcepts.contains(parts[parts.length-x]))
               for(String n : TConcepts)
                if((parts[parts.length-x]).contains(n))
                { flag=1;
                }
                    //if(flag==0)
                       // break;
                // if(TConcepts.contains(parts[parts.length-y]))
                 for(String n : TConcepts)
                 if((parts[parts.length-y]).contains(n))
                { flag1=1;
                }
                
                if(flag==1&&flag1==1)
                {
                    writer.write(line);
                    writer.newLine();
                }
                flag=0;
                flag1=0;
              line = br.readLine();
            }
    br.close();
    br1.close();
    writer.close();
}
}

