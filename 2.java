import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class 2 {

	public static void main(String[] args) {
		readFromCSVFile("Sacramentorealestatetransactions.csv","price");
	}
	
	 private static void readFromCSVFile(String path,String header)  {
		try(BufferedReader br = new BufferedReader(new FileReader(path));) {
        String headerValues = br.readLine();
        int columnIndex=0;
        if (headerValues != null) {
            String[] columns = headerValues.split(",");
            columnIndex=Arrays.asList(columns).indexOf(header);
        }
        String line=br.readLine();
        while(line!=null) {
            	String[] values=line.split(",");
            	System.out.println(""+values[columnIndex]+"  ");
            	line=br.readLine();
          }
		}catch(Exception e) {
			System.out.println("Exception occured while processing file"+e.getMessage());
		}
	}

}
