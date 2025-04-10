import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Colossus {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("colossus.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
//			System.out.println(Long.valueOf(scan.nextLine())<=10000?"Hulk here we come.":"Lunk Alarm!!"); non big int
			BigInteger inty = new BigInteger(scan.nextLine());
			int m = inty.compareTo(new BigInteger("10000"));
			System.out.println(m<0||m==0?"Hulk here we come.":"Lunk Alarm!!");
		}
		
	}
}