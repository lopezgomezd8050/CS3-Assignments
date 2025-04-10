import java.math.BigInteger;
import java.util.ArrayList;

public class Gee {
	
	public static BigInteger geeceedee(int n1, int n2) {
		BigInteger num1 = BigInteger.valueOf(n1);
		BigInteger num2 = BigInteger.valueOf(n2);
		return num1.gcd(num2);
	}
	
	public static int geese(double n1, double n2) { // if its stupid and it works its not stupid
		int gcdee = 1;
		int iterate;
		if(n1>n2) {
			iterate=(int)n1;
		} else {
			iterate=(int)n2;	
		}
		ArrayList<Integer> A_n1 = new ArrayList<Integer>();
		ArrayList<Integer> A_n2 = new ArrayList<Integer>();

		for(int i = iterate; i>0;i--) {
			if (n1/i % 1 == 0) {
				A_n1.add((int)n1/i);
			}
			if (n2/i % 1 == 0) {
				A_n2.add((int)n2/i);
			}
		}
		for(Integer int1: A_n1) {
			for(Integer int2:A_n2) {
				if(int1.equals(int2)) {
					gcdee=int1;
				}
			}
			
		}
		
		return gcdee;
	}
	
	public static int gato(int n1, int n2) { // much more elegant
		if (n1==n2) {return n1;}
		else if (n1<n2) {return gato(n2,n1);}
		int n3 = n1 % n2;
		if(n3==0) {return n2;}
		return gato(n2,n3);
	}
	
	public static int honorable(int n1, int n2) {
		if (n1==n2) {return n1;}
		else if (n1<n2) {return gato(n2,n1);}
		int n3 = n1;
		while(n3>0) {
			n3-=n2;
		}
		if(n3==0) {return n2;}
		return gato(n2,n3);
	}
	
	public static void main(String[] args) {
		System.out.println(geese(16,36));
		System.out.println(geeceedee(16,36));
		System.out.println(gato(16,36));
		System.out.println(honorable(16,36));

	}
}
