import java.io.*;
import java.util.*;

public class Ksenyia {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("ksenyia.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		ArrayList<String> usernames = new ArrayList<String>();
		ArrayList<String> passwords = new ArrayList<String>();
		for(int i = 0; i<test_cases;i++) {
			String username = scan.nextLine();
			String password = scan.nextLine();
			boolean userValid = true;
			boolean passValid = true;
			
			if(username.charAt(0)!=username.toUpperCase().charAt(0)) {
				userValid = false;
			} 
			
			if(username.matches("[^a-zA-Z\\d\\s:]")) {
				userValid = false;
			}
			
			if(username.length()>20||username.length()<8) {
				userValid = false;
			}
			
			if(usernames.contains(username)) {
				userValid = false;
			}
			usernames.add(username);
			
			
			if(password.length()==password.replaceAll("[^A-Za-z0-9]", "").length()) { // special chars maybe
				passValid = false;
			}
			
//			if(!password.contains("[A-Za-z0-9]")) {
//				passValid = false;
//			}
			
			if(password.length()>30||password.length()<10) {
				passValid = false;
			}
			
			if(passwords.contains(password)) {
				passValid = false;
			}
			passwords.add(password);
			
			for(int k = 0; k<password.length()-2;k++) {
				char testy1 = password.toCharArray()[k];
				char testy2 = password.toCharArray()[k+1];
				char testy3 = password.toCharArray()[k+2];
				if(testy1==testy2 && testy2==testy3) {
					passValid = false;
					break;
				}

			}
			
			if(password.matches("\\s+")) {
				passValid=false;
			}
			
			
			
			if(userValid&&passValid) {
				System.out.println("Valid");
			} else if(!userValid&&!passValid) {
				System.out.println("Both Invalid");
			} else if(!userValid) {
				System.out.println("Username Invalid");
			} else if(!passValid) {
				System.out.println("Password Invalid");
			} 
		}
	}
}
