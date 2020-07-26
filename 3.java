import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 3 {

	public static final String FIRSTDOTLAST ="first.last@";
	public static final String LASTDOTFIRST ="last.first@";
	public static final String FIRSTUNDERSCORELAST  ="first_last@";
	public static final String LASTUNDERSCOREFIRST  ="last_first@";
	public static final String FIRSTCHARLAST  ="first(1)last@";
	public static final String LASTCHARFIRST   ="last(1)first@";
	public static final String COMMON_EMAIL    ="";

	public static void main(String[] args) {				
			Map<String, String> testMap = new HashMap<String, String>(){{put("JSmith@gmail.com", "Jonathan Smith");put("John.Doe@gmail.com", "John Doe"); put("sFraser@yahoo.com", "Sara Ann Fraser");put("Mark_Williams@gmail.com", "Mark P Williams");}};
			for(Map.Entry<String, String> entry : testMap.entrySet()) {
				NameParser parser = new NameParser();
				parser.parse(entry.getValue());
				checkFormat(entry.getKey(),parser.getFirstName(),parser.getLastName());	
			}			
	}
	public static void checkFormat(String email, String firstName, String lastName) {
			boolean isEmailIdValid=validateEmail(email);
		if(isEmailIdValid) {
			String fullName=email.substring(0,email.indexOf("@"));		
			String[] dotSplitted =null;
			if(fullName.indexOf('.')!=-1) {
				dotSplitted= fullName.split("\\.");
			}
			String[] underScoreSplitted=null;
			if(fullName.indexOf('_')!=-1) {
				underScoreSplitted= fullName.split("\\_");
			}		
			if(dotSplitted!=null && dotSplitted.length>=2) {
				if(firstName.equals(dotSplitted[0]) && lastName.equals(dotSplitted[1]))
					System.out.println("Email Format for email: "+email+" is :"+FIRSTDOTLAST);
				if(lastName.equals(dotSplitted[0]) && firstName.equals(dotSplitted[1]))
					System.out.println("Email Format for email: "+email+" is :"+LASTDOTFIRST);
			}else if(underScoreSplitted!=null && underScoreSplitted.length>=2) {
				if(firstName.equals(underScoreSplitted[0]) && lastName.equals(underScoreSplitted[1]))
					System.out.println("Email Format for email: "+email+" is :"+FIRSTUNDERSCORELAST);
				if(lastName.equals(underScoreSplitted[0]) && firstName.equals(underScoreSplitted[1]))
					System.out.println("Email Format for email: "+email+" is :"+LASTUNDERSCOREFIRST);
			}else if((firstName.charAt(0)+lastName).equalsIgnoreCase(fullName)) {
				System.out.println("Email Format for email: "+email+" is :"+FIRSTCHARLAST);
			}else if((lastName.charAt(0)+firstName).equalsIgnoreCase(fullName)) {
				System.out.println("Email Format for email: "+email+" is :"+LASTCHARFIRST);
			}else{
				System.out.println("Email Format for email: "+email+" is :"+COMMON_EMAIL);
			}		
		
		}else {
			System.err.println("Provided email id is not valid.");
		}
	}
	private static boolean validateEmail(String email) {
		boolean isEmailValid=true;
		Pattern validEmailPattern=Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		 Matcher matcher = validEmailPattern.matcher(email);
		 isEmailValid=matcher.find();
		return isEmailValid;
	}
	
}
