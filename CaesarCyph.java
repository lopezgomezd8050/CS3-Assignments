import java.io.*;
import java.util.*;

public class CaesarCyph {
	
	public static String shifty (String str, int amt) {
		String shifted = str;
		for(int i = 0; i<amt;i++) {
			shifted=shifted.substring(1)+shifted.substring(0,1);
		}
		return shifted;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("caesarcyph.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		for(int i = 0; i<test_cases;i++) {
			for(int ii = 0; ii<alphabet.length();ii++) { //iterate over the words rather than the alphabet first lmao
				String betabet = shifty(alphabet, ii);
				System.out.println(betabet);
				char[] chared = scan.nextLine().toCharArray();
				String finalstring = "";
				for(int iii=0; iii<chared.length;iii++) {
					finalstring+=String.valueOf(chared[iii]).replace(betabet.charAt(ii),alphabet.charAt(ii));
				}
				System.out.println(finalstring);
			}
		}
	}
}
