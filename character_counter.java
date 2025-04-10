import java.io.*;
import java.util.*;

public class character_counter {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr19.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			String str = scan.nextLine();
			
			String compareNum = str.replaceAll("[^0-9]", "");
			String compareLetter = str.replaceAll("[^A-Z]", "");
			String compareNot = str.replaceAll("[A-Z0-9]", "");
			
			System.out.println("LETTERS: " + compareLetter.length() + " DIGITS: " + compareNum.length() + " OTHER: " + compareNot.length());
		}
	}
}
