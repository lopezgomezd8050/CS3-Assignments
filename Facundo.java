import java.io.*;
import java.util.*;

public class Facundo {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("facundo.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			String[] strung = scan.nextLine().split("\\s+");
			for(int j=0;j<Integer.valueOf(strung[1]);j++) {
				char[] upper;
				char[] lower;
				if(strung[0].length()%2==0) { //could be done as a ternary but oh well
					upper = strung[0].substring(0,strung[0].length()/2).toCharArray();
					lower = strung[0].substring(strung[0].length()/2).toCharArray();
				} else {
					upper = strung[0].substring(0,strung[0].length()/2+1).toCharArray();
					lower = strung[0].substring(strung[0].length()/2+1).toCharArray();
				}
				String construct="";
				for(int k = 0; k<lower.length;k++) {
					construct+=upper[k];
					construct+=lower[k];
				}
				if(strung[0].length()%2==1) { //something something it works by the working principle, coined by john work
					construct+=upper[upper.length-1]; //append last letter since if its odd it doesnt append it in the for loop
				}
				strung[0]=construct;
			}
			System.out.println(strung[0]);
		}
	}
}
