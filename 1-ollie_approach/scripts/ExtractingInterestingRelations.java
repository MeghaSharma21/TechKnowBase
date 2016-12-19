// It extracts the triples containing the desired relation, say “is” relation.

import java.io.*;

public class ExtractingInterestingRelations {

    public static void main(String[] args) throws IOException {
        
          BufferedReader br=new BufferedReader(new FileReader("triplesContainingInterestingConcepts"));
          File file = new File("FileContainingInterestingRelations1");
         file.createNewFile();
         BufferedWriter writer = new BufferedWriter(new FileWriter(file));
       
         String line = br.readLine();
         String relation="_is";
          while (line != null)
         {
             String[] parts = line.split(";");
             if(relation.equalsIgnoreCase(parts[1]))
                 writer.write(line+"\n");
             line = br.readLine();
        }
          
          br.close();
          writer.close();
         
    }
    
}
