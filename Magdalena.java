import java.io.*;
import java.util.*;

public class Magdalena {
	final static private String RADIX = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	public static long baseBto10(int base, char[] b) {
		long val=0;
		for(int g = 0; g<b.length;g++) {
			int place = RADIX.indexOf(b[g]);
			val+=place*Math.pow(base, (b.length-g-1));
		}
		return val;
	}
	public static int baseBsum(int base, char[] b) {
		int sum=0;
		for(int g = 0; g<b.length;g++) {
			int place = RADIX.indexOf(b[g]);
			sum+=place;
		}
		return sum;
	}
	public static char[] base10toB(int base, long ten) {
		int le=0;
		while((ten>=Math.pow(base, le))) {
			le++;
		}
		char[] B=new char[le];
		for(int i = 0; i<le;i++) {
			long num = (long)(ten/Math.pow(base, i));
			char cha = RADIX.charAt((int)num%base);
			B[le-i-1]=cha;
		}
		return B;
	}

	public static int baseBminsum(int base, char[] b) {
		int sum=baseBsum(base,b);
		if(b.length==1) {
			return RADIX.indexOf(b[0]);
		}
		//m-n-1 sum
		long m =baseBto10(base, b);
		char[] interB = new char[b.length-1];
		for(int i = 0;i<interB.length;i++) {
			interB[i]=b[i+1];
		}
		long n =baseBto10(base, interB);
		long summa = m-n-1;
		char[] newB = base10toB(base,summa);
		if(baseBsum(base,newB)>sum) {
			sum=baseBsum(base,newB);
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("magdalena.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			int base = scan.nextInt();
			char[] unparsed = scan.nextLine().replace(" ","").toCharArray();
			int value = baseBminsum(base, unparsed);
			
			System.out.println(base10toB(base,value));
		}
	}
}
