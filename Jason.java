import java.io.*;
import java.util.*;

public class Jason {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("jason.dat"));
		  double[] parsed = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(a->Double.parseDouble(a)).toArray();
		  int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		  int pointer = 0;
		  int[] average = new int[12];
		  for(int i = 0; i<12;i++) {
			  double tempAvg = 0;
			  for(int k = 0; k<months[i];k++) {
				  tempAvg+=parsed[pointer];
				  pointer++;
			  }
			  average[i]=(int)Math.round((tempAvg/months[i]));
		  }
		  int max = Integer.MIN_VALUE;
		  for(int val:average) {
			  if(val>max) {
				  max=val;
			  }
		  }
		  for(int i = 0; i<max;i++) {
			  for(int k = 0; k<12;k++) {
				  if(average[k]>=max-i) {
					  System.out.print("***** ");
				  } else {
					  System.out.print("      ");
				  }
			  }
			  System.out.println();
		  }
		  System.out.println(" Jan   Feb   Mar   Apr   May   Jun   Jul   Aug   Sep   Oct   Nov   Dec ");
//		  System.out.println(Arrays.toString(average));
	}
}
