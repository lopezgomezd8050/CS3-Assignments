import java.io.*;
import java.util.*;

public class Brittany {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("brittany.dat"));
//		int test_cases = Integer.parseInt(scan.nextLine());
//		for(int i = 0; i<test_cases;i++) {
//			
//		}
		double sum=0;
		double count=0;
		String[] s = scan.nextLine().split("\\s+");
		for(String ss: s) {
			double f = Double.valueOf(ss);
			sum+=f;
			count++;
		}
		System.out.printf("%.2f", sum);
		System.out.print(" ");
		System.out.printf("%.2f", (sum/count));

		
	}
}
