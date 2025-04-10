import java.io.*;
import java.util.*;

public class Anisha {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("anisha.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			System.out.println(Integer.valueOf(scan.nextLine().split("\\s+")[0])>=15?"Way to go, H2O.":"On my way to Dehydration Station.");
		}
	}
}
