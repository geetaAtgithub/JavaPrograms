import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class 1 {
	public static void main(String[] args) {
		readAndcompareFiles("file1.txt","file2.txt");
	}
	
	private static void readAndcompareFiles(String path1, String path2) {
		try {			
			List<String> lines1=Files.readAllLines(Paths.get(path1));
			List<String> lines2=Files.readAllLines(Paths.get(path2));
			for(String name:lines1) {
				if(!lines2.contains(name)) {
					System.out.println("This file name only exists in file 1 : "+name);
				}
			}
      }catch(Exception e) {System.out.println("Exception occured while processing file"+e.getMessage());}
		
	}
}