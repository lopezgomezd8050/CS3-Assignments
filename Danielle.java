import java.io.*;
import java.util.*;

public class Danielle {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("danielle.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			String[] unparsed = scan.nextLine().split("[,]");
			int[] normalized = new int[4];
			for(int k = 0; k<normalized.length;k++) {
				normalized[k]=Integer.valueOf(unparsed[k])-(k+1);
			}
			int sum = 1; //as 0,0,0,0 is 1
			for(int k = 0; k<normalized.length;k++) {
				int adjBase=0;
				switch(k) {
				  case 0:
					adjBase=1;
				    break;
				  case 1:
					adjBase=9;
				    break;
				  case 2:
					adjBase=72;
				    break;
				  case 3:
					adjBase=504;
				    break;
				}
				sum+=normalized[k]*adjBase;
			}
			System.out.println(sum);
		}
	}
}
