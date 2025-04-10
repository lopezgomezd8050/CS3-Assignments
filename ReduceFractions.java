import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class ReduceFractions {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("reducefractions.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			String[] slop = scan.nextLine().split("\\s+");
			int num = Integer.valueOf(slop[0]);
			int den = Integer.valueOf(slop[1]);
			if(num==den) { //edgecase probably doesnt exist but just to be sure
				System.out.println("1");
			} else if (num>den) { //mixed fraction
				int times = num/den;
				int newNum=num-(times*den);
				System.out.print(times+" ");
				System.out.println(slopF(newNum,den));
				
			} else if (num<den) { //normal fraction
				System.out.println(slopF(num,den));
				
			}
		}
	}

	private static String slopF(int num, int den) {
		if(num==0) {
			return"";
		}
		BigInteger n1 = new BigInteger(String.valueOf(num));
		BigInteger n2 = new BigInteger(String.valueOf(den));
		BigInteger gcdB = n1.gcd(n2);
		int gcd = gcdB.intValue();
		num/=gcd;
		den/=gcd;
		return num+"/"+den;
		
	}
}
