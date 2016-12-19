
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Megha Sharma
 */
public class HearstPattern_isA {
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("TextIntoSentences"));
         File file = new File("HearstPattern_isA1");
         file.createNewFile();
         BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        // System.out.println("1");
         String line,x;
        String pattern = "##(.*?)### is a ##(.*?)###";
        String pattern1 = "##(.*?)### is an ##(.*?)###";


        int y;
         while((line=br.readLine())!=null)
         {  //System.out.println("2");

              Pattern r = Pattern.compile(pattern);
              Matcher m = r.matcher(line);
 Pattern r1 = Pattern.compile(pattern1);
              Matcher m1 = r1.matcher(line);

        if(m.find())
    {  
      if(m.group(1).contains("#"))
    { 
      x=m.group(1).substring(m.group(1).lastIndexOf("##")+2);
      if(!x.equals(m.group(2)))
      writer.write(x+" TYPE OF "+m.group(2)+"\n");
    }
   else
   if(!m.group(1).equals(m.group(2)))
    writer.write(m.group(1)+" TYPE OF "+m.group(2)+"\n");
                    
     //writer.write(m.group(3)+" SubFieldOf "+x+"\n");              
    }
    else if(m1.find())
    {
      if(m1.group(1).contains("#"))
     { 
      x=m1.group(1).substring(m1.group(1).lastIndexOf("##")+2);
      if(!x.equals(m1.group(2)))
      writer.write(x+" TYPE OF "+m1.group(2)+"\n");
     }
     else
     if(!m1.group(1).equals(m1.group(2)))
    writer.write(m1.group(1)+" TYPE OF "+m1.group(2)+"\n");
    }
              
         }
writer.close();
}
}


