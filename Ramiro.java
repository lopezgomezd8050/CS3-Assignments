import java.io.*;
import java.util.*;

public class Ramiro {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("ramiro.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			String[] unparsed = scan.nextLine().split("\\s+");
			long num1 = Long.valueOf(unparsed[0], 16);
			long num2 = Long.valueOf(unparsed[1], 16);
			String str1="0".repeat(32-Long.toBinaryString(num1).length())+Long.toBinaryString(num1);
			String str2="0".repeat(32-Long.toBinaryString(num2).length())+Long.toBinaryString(num2);
			int delta = 0;
			for(int j = 0; j<32;j++) {
				if(str1.charAt(j)!=str2.charAt(j)) {
					delta++;
				}
			}
			System.out.println(delta);
		}
	}
}
