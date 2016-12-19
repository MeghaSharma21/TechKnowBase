// Hearst pattern: In; Relation: SubFieldOf
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
public class HearstPatternForIn {
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("TextIntoSentences"));
         File file = new File("HearstPatternForSubField");
         file.createNewFile();
         BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        // System.out.println("1");
         String line;
        String pattern = "^in (.+?),(.+?)##(.+?)###";
        String pattern1 = "##### in(.*?),(.*?)##(.*?)###";
        outer:
         while((line=br.readLine())!=null)
         {  //System.out.println("2");

              Pattern r = Pattern.compile(pattern);
              Matcher m = r.matcher(line);
 	      Pattern r1 = Pattern.compile(pattern1);
              Matcher m1 = r1.matcher(line);
              if(m.find())
              { String x=m.group(1);
               // if(x.contains("the field of")||x.contains("context of")||x.contains("#"))
                    x=x.replaceAll("the field of","").replaceAll("context of", "").replaceAll("#","");
                    if(x.contains("this")||x.contains("these"))
                        continue;
                    String[] arr=x.split(" ");
                    for(int a=0;a<arr.length;a++)
                        if(arr[a].equals("a"))
                            continue;
                    
                   writer.write(m.group(3)+" ; SubFieldOf ; "+x+"\n");
                  //writer.write(line+"\n");
                    //System.out.println(line+"\n");
             }
              else
                  if(m1.find())
                 {
		  String x=m1.group(1);
               // if(x.contains("the field of")||x.contains("context of")||x.contains("#"))
                    x=x.replaceAll("the field of","").replaceAll("context of", "").replaceAll("#","");
                    if(x.contains("this")||x.contains("these"))
                        continue;
                    String[] arr=x.split(" ");
                    for(int a=0;a<arr.length;a++)
                        if(arr[a].equals("a"))
                            continue outer;

		  writer.write(m1.group(3)+" ; SubFieldOf ; "+x+"\n");
                 }  
         }
}
}


