import java.io.*;
import java.util.*;

public class Mother {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("mother.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			int turns = Integer.parseInt(scan.nextLine());
			int sent = 0;

			for(int j = 0; j<turns; j++) {
				sent+=j;
			}
			System.out.println(sent);
		}
	}
}
