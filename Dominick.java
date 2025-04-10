import java.io.*;
import java.util.*;

public class Dominick {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("dominick.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			hanoi(scan.nextLine().split("\\s+").length);
		}
	}

	private static void hanoi(int length) {
		// TODO Auto-generated method stub
		
		System.out.println(length);
		
		System.out.println();
		
	}
}
