import java.io.*;
import java.util.*;

public class Becker {	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("becker.dat"));
		while(scan.hasNextLine()) {
			long A = scan.nextLong();
			double r = scan.nextDouble()/100;
			int n = scan.nextInt();
			int t = scan.nextInt();
			double fin = (A/(Math.pow((1+((double)r/n)), (n*t))));
			long a = (long)Math.ceil(fin);
			System.out.println(a);
		}
	}
}
