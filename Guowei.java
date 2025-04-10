import java.io.*;
import java.util.*;

public class Guowei {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("guowei.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			
			int num = Integer.parseInt(scan.nextLine());
			String word = scan.nextLine();
			word+=" "+word;
			word+=" "+word;
			
			System.out.println(word.substring(num, num+40));
		}
	}
}
