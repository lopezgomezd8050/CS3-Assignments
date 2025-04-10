import java.io.*;
import java.util.*;

public class Arusha {
	
	public static String rightRotation(String stringy) {
		String last_letter = stringy.substring(stringy.length()-1,stringy.length());
		String string_with_last_letter_removed = stringy.substring(0, stringy.length()-1);
		return (last_letter+string_with_last_letter_removed);
	}
	public static String leftRotation(String stringy) {
		String first_letter = stringy.substring(0,1);
		String string_with_first_letter_removed = stringy.substring(1, stringy.length());
		return (string_with_first_letter_removed+first_letter);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("arusha.dat"));
		int num=Integer.parseInt(scan.nextLine());
		for(int i = 0; i<num;i++) {
			String[] listy = scan.nextLine().split("\\s+"); //regex split for spaces
			char[] rotation_instructions = listy[1].toCharArray();
			for(char ch: rotation_instructions) {
				if (ch == 'R') {
					listy[0] = rightRotation(listy[0]);
				} 
				else if (ch == 'L') {
					listy[0] = leftRotation(listy[0]);
				}
			}
			System.out.println(listy[0]);
		}
	}
}
