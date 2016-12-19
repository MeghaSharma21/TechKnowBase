//  This extracts all relations along with their frequency of occurrence. The relations have been sorted in decreasing order of frequency.

import java.io.*;
import java.util.*;

public class CalculatingFrequencyOfRelations {

    public static void main(String[] args)  throws IOException
    {    int count=0,x=1,y;
         BufferedReader br=new BufferedReader(new FileReader("triplesContainingInterestingConcepts"));
         String line = br.readLine();
         ArrayList<String> relations = new ArrayList<String>();
           HashMap<String, Integer> frequency = new HashMap<String, Integer>();
         while (line != null)
         {
             String[] parts = line.split(";");
             if(!relations.contains(parts[1]))
             { relations.add(parts[1]);
                frequency.put(parts[1],1);
               
             }
             else
             {
                 //y=relations.indexOf(parts[1]);
                 count=frequency.get(parts[1]);
                 frequency.put(parts[1],count+1);
             }
              line = br.readLine();
         }
         /*  HashMap<Integer,String> FR = new HashMap<Integer,String>();
          for(int i=0;i<frequency.size();i++)
           {
             FR.put(frequency.get(i),relations.get(i));
           } */
            LinkedHashMap<String,Integer> sortedMap =new LinkedHashMap<String,Integer>();
          sortedMap =sortHashMapByValues(frequency);
         br.close();
        
         
        
    }
   public static LinkedHashMap<String, Integer> sortHashMapByValues(
        HashMap<String, Integer> passedMap) throws IOException{
     File file = new File("FileContainingInterestingRelations");
         file.createNewFile();
         BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    List<String> mapKeys = new ArrayList<String>(passedMap.keySet());
    List<Integer> mapValues = new ArrayList<Integer>(passedMap.values());
    // To sort lists in descending order
    Collections.sort(mapValues);
     Collections.reverse(mapValues);
    Collections.sort(mapKeys);
    Collections.reverse(mapKeys);


    LinkedHashMap<String, Integer> sortedMap =
        new LinkedHashMap<String, Integer>();

    Iterator<Integer> valueIt = mapValues.iterator();
    while (valueIt.hasNext()) {
        Integer val = valueIt.next();
        Iterator<String> keyIt = mapKeys.iterator();

        while (keyIt.hasNext()) {
            String key = keyIt.next();
            Integer comp1 = passedMap.get(key);
            Integer comp2 = val;

            if (comp1.equals(comp2)) {
                keyIt.remove();
                sortedMap.put(key, val);
                writer.write(key+","+val+"\n");
                break;
            }
        }
    }
    writer.close();
    return sortedMap;
}
    
}
