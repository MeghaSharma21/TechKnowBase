//segregating triples by relation names which are interesting to us
 java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FindingSpecificRelations {

	public static void main(String[] argv) throws Exception {    
		  BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Megha Sharma\\Desktop\\SievedTemplates1"));
		  File file = new File("C:\\Users\\Megha Sharma\\Desktop\\theoryRelation");
	      file.createNewFile();
	      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	      File file1 = new File("C:\\Users\\Megha Sharma\\Desktop\\mainRelation");
	      file1.createNewFile();
	      BufferedWriter writer1 = new BufferedWriter(new FileWriter(file1));
	      File file3 = new File("C:\\Users\\Megha Sharma\\Desktop\\typesRelation");
	      file3.createNewFile();
	      BufferedWriter writer3 = new BufferedWriter(new FileWriter(file3));
	      File file4 = new File("C:\\Users\\Megha Sharma\\Desktop\\ComponentsRelation");
	      file4.createNewFile();
	      BufferedWriter writer4 = new BufferedWriter(new FileWriter(file4));
	      File file5 = new File("C:\\Users\\Megha Sharma\\Desktop\\TechnologiesRelation");
	      file5.createNewFile();
	      BufferedWriter writer5 = new BufferedWriter(new FileWriter(file5));
String line;
while((line=br.readLine())!=null)
{	line=line.toLowerCase();
	/*if(line.contains("{"))
	line=line.replaceAll("{", "");
	if(line.contains("}"))
		line=line.replaceAll("}", "");
	if(line.contains("<"))
		line=line.replaceAll("<", "");
	if(line.contains(">"))
		line=line.replaceAll(">", "");
	if(line.contains("--"))
		line=line.replaceAll("--", ""); */
	
	String[] temp=line.split(";");
	if(temp[1].contains("theory")||temp[1].contains("theories"))
		writer.write(temp[2]+";"+temp[1]+";"+temp[0]+"\n");
	else if(temp[1].contains("main"))
	writer1.write(temp[2]+";"+temp[1]+";"+temp[0]+"\n");
	else if(temp[1].contains("type"))
		writer3.write(temp[2]+";"+temp[1]+";"+temp[0]+"\n");
	else if(temp[1].contains("component"))
		writer4.write(temp[2]+";"+temp[1]+";"+temp[0]+"\n");
	else if(temp[1].contains("technology")||temp[1].contains("technologies"))
		writer5.write(temp[2]+";"+temp[1]+";"+temp[0]+"\n");
}
writer.close();
writer1.close();
writer3.close();
writer4.close();
writer5.close();
br.close();

}
}
