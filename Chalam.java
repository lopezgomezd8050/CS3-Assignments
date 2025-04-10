import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Chalam {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("chalam.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			BigInteger bNumber = new BigInteger(scan.nextLine());
			int number = Integer.parseInt(bNumber.toString());
			if(bNumber.isProbablePrime(128)) {
				System.out.println(number);
				continue;
			}
			String ans = "";
//			System.out.println("Testcases: "+i);
			for(int j = 2; j < number; j++) {
				if(number==j||new BigInteger(Integer.toString(number)).isProbablePrime(128)) {
					break;
				}
				if(number%j==0) {
					int amt = 0;
					while(number%j==0) {
						number/=j;
						amt++;
					}
					ans+=amt>1?j+"^"+amt+" ":j+" ";
				}
			}
//			System.out.println(number);
			System.out.println(ans+""+number);
		}
	}
}
