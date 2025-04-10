import java.io.*;
import java.util.*;

public class Diane {
	public static String dectofrac(double num) {
		int numerator = 1;
		int denominator = 1;
		while (true){
			if(Math.abs(Math.abs(((double)numerator/denominator))-Math.abs(num))<.00001) { //roughtly equal
				return numerator+"/"+denominator;
			} else {
				if(denominator<=numerator) {
					denominator++;
					numerator=1;
				} else {
					numerator++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("diane.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			String[] unparsed = scan.nextLine().split("\\s+");
			boolean andreachedyet=false;
			double sum1=0;
			double sum2=0;
			boolean isneg=false;
			for(String k: unparsed) {
				double temp=0;
				if(k.equals("and")){
					andreachedyet=true;
					isneg=false;
				} else if(k.contains("/")) {
					String[] a = k.split("/");
					temp=Math.abs(Double.valueOf(a[0])/Double.valueOf(a[1]));
				} else {
					temp=Math.abs(Double.valueOf(k));
				}
				if(k.contains("-")) {
					isneg=true;
				}
				if(isneg) {
					temp*=-1;
				}
				if(!andreachedyet) {
					sum1+=temp;
				} else {
					sum2+=temp;
				}

			}
			double sumf=sum1+sum2;
			if(sumf%1==0) { //whole number
				System.out.println((int)sumf);
			} else { //fraction
				//System.out.println(sumf);
				if((int)sumf==0) { //only fraction; no number
					//System.out.println("A");
					System.out.println(dectofrac(sumf%1));
				} else { //mixed number
					//System.out.println("B");
					System.out.println((int)sumf+" "+dectofrac(sumf%1));
				}
			}
		}
	}
}
