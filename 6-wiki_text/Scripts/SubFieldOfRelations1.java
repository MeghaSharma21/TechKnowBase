// Breaks the text into sentences and tags the technical concepts in each sentence and stores the results in a file named TextIntoSentences

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SubFieldOfRelations1
{

    public static void main(String[] args) throws IOException
    {
        
         BufferedReader br=new BufferedReader(new FileReader("MergedListOfTC"));
         BufferedReader br2=new BufferedReader(new FileReader("MergedList_TC"));
      File file = new File("TextIntoConcepts");
         file.createNewFile();
         BufferedWriter writer = new BufferedWriter(new FileWriter(file));
          File file1 = new File("TextIntoSentences");
         file.createNewFile();
         BufferedWriter writer1 = new BufferedWriter(new FileWriter(file1));
         String line,line1;
         boolean x=true,y=true,z;
         //ArrayList<String> TConcepts = new ArrayList<String>();
         HashMap<String,Integer> TConcepts = new HashMap<String,Integer>();

            while((line1 = br2.readLine()) != null)
            {     line1=line1.toLowerCase();
               // line1=line1.replaceAll("\\s+","_");
                TConcepts.put(line1,1);
            }
            
            
         while((line=br.readLine())!=null)
          
    {line=line.toLowerCase();
              String[] temp=line.split(" ");
              
              for(int j=0;j<temp.length;j++)
              {
                  if((j<temp.length-5)&&TConcepts.containsKey(temp[j]+" "+temp[j+1]+" "+temp[j+2]+" "+temp[j+3]+" "+temp[j+4]+" "+temp[j+5]))
                  {writer.write("##"+temp[j]+" "+temp[j+1]+" "+temp[j+2]+" "+temp[j+3]+" "+temp[j+4]+" "+temp[j+5]+"### "); j=j+5;}
                   else if((j<temp.length-4)&&TConcepts.containsKey(temp[j]+" "+temp[j+1]+" "+temp[j+2]+" "+temp[j+3]+" "+temp[j+4]))
                  {writer.write("##"+temp[j]+" "+temp[j+1]+" "+temp[j+2]+" "+temp[j+3]+" "+temp[j+4]+"### "); j=j+4;}
                   else if((j<temp.length-3)&&TConcepts.containsKey(temp[j]+" "+temp[j+1]+" "+temp[j+2]+" "+temp[j+3]))
                  {writer.write("##"+temp[j]+" "+temp[j+1]+" "+temp[j+2]+" "+temp[j+3]+"### "); j=j+3;}
                  else if((j<temp.length-2)&&TConcepts.containsKey(temp[j]+" "+temp[j+1]+" "+temp[j+2]))
                  {writer.write("##"+temp[j]+" "+temp[j+1]+" "+temp[j+2]+"### "); j=j+2;}
                  else if((j<temp.length-1)&&TConcepts.containsKey(temp[j]+" "+temp[j+1]))
                  { writer.write("##"+temp[j]+" "+temp[j+1]+"### "); j++;}
                   else  if(TConcepts.containsKey(temp[j]))
                  {
                      writer.write("##"+temp[j]+"### ");
                  }
                 else
                   writer.write(temp[j]+" ");
              }
                //line=line.replaceAll("\\s+","_");
             /*
             for(String n : TConcepts)
         {int index = line.indexOf(n);
             while (index >= 0) 
             {  if((line.length()>1)&&(n.length()>0))
                 {if(index==0)
                  {if (n.length()>line.length()-1)
                   writer.write("##"+n+"###");
                  else
                     writer.write("##"+n+"###"+line.substring(n.length(),line.length()-1));
                  }
                 else
                 {if (n.length()+index>line.length()-1)
                  line.substring(0,index-1)+"##"+n+"###");
                  else
                    writer.write(line.substring(0,index-1)+"##"+n+"###"+line.substring(n.length()+index,line.length()-1));
                  }
                  index = line.indexOf(n, index + 1);
             }
             }
         } */
        } 
         br.close();
          BufferedReader br1=new BufferedReader(new FileReader("TextIntoConcepts"));
         while((line=br1.readLine())!=null)
         {
             
           String pattern = "##(.*).(.*)###";
            // Create a Pattern object
            Pattern r = Pattern.compile(pattern);
            // Now create matcher object.
            Matcher m = r.matcher(line);
             if (m.find( )) 
             {
                   String[] sentences = line.split("[\\.\\!\\?]");
                   for (int i=0;i<sentences.length;i++)
                     if(sentences[i].contains("##"))
            {
            writer1.write(""+sentences[i]+sentences[i+1]+"."+"\n");
            i++;
            }
            
            else
              writer1.write(""+sentences[i]+"."+"\n");
              }   
                   
        else
        {       String[] sentences = line.split("[\\.\\!\\?]");
            for (int i=0;i<sentences.length;i++)
                        writer1.write(""+sentences[i]+"."+"\n");
        }
                   
         
            

         }
         writer.close();
         br1.close();
         }
    }




    

    






