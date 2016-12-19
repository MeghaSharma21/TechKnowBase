
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
public class HearstPattern_isAnAlgorithmFor {
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("TextIntoSentences"));
         File file = new File("HearstPattern_isAnAlgorithmFor");
         file.createNewFile();
         BufferedWriter writer = new BufferedWriter(new FileWriter(file));
          File file1 = new File("ListOfAlgorithms");
         file1.createNewFile();
         BufferedWriter writer1 = new BufferedWriter(new FileWriter(file1));
         String line,x;
        String pattern = "##(.*?)### is an ##algorithm### (.*).";


        int y;
         while((line=br.readLine())!=null)
         {  //System.out.println("2");

              Pattern r = Pattern.compile(pattern);
              Matcher m = r.matcher(line);

        if(m.find())
    {  
      if(m.group(1).contains("#"))
    { 
      x=m.group(1).substring(m.group(1).lastIndexOf("##")+2);

      if(!x.equals(m.group(2)))
     { z=m.group(2);
	if(m.group(2).contains("#"))
	z=z.replaceAll("#","");

	writer.write(x+" IS AN ALGORITHM "+z+"\n");
      writer1.write(x+" TYPEOF algorithm\n");
	}
    }
   else
   if(!m.group(1).equals(m.group(2)))
   { z=m.group(2);
	if(m.group(2).contains("#"))
	z=z.replaceAll("#","");

	writer.write(m.group(1)+" IS AN ALGORITHM "+z+"\n");
     writer1.write(m.group(1)+" TYPEOF algorithm\n");
   }
                    
 //    writer.write(m.group(1)+" TYPEOF "+m.group(2)+"\n");              
    }
   
  }
writer.close();
writer1.close();
}
}


