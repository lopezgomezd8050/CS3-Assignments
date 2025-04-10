import java.io.*;
import java.util.*;

public class Stats {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("stats.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			String[] unparsed = scan.nextLine().split("\\s+");
			int len = unparsed.length;
//			System.out.println(len);
			int[] parsed = new int[len];
			for(int j=0;j<len;j++) {
				parsed[j]=Integer.valueOf(unparsed[j]);
			}
			Arrays.sort(parsed);
//			System.out.println(Arrays.toString(parsed));
			double median=0;
			if(len%2==1) {
				median=parsed[len/2];
			} else {
				median+=parsed[len/2-1];
				median+=parsed[len/2];
				median/=2;
			}
//			System.out.println(median);
			double average=0;
			for(int inty: parsed) {
				average+=inty;
			}
			average/=len;
//			System.out.println(average);
			System.out.printf("%.2f",Math.abs(average-median));
			System.out.println();
		}
	}
}
