import java.io.*;
import java.util.*;

public class Wojtek {
	public static int diffy(int[] arr) {
		if(Arrays.toString(arr).equals("[0, 0, 0, 0]")) { //if its stupid and works its not stupid
			return 0;
		}
		int[] newarr =new int[4];
		newarr[0]=Math.abs(arr[0]-arr[1]);
		newarr[1]=Math.abs(arr[1]-arr[2]);
		newarr[2]=Math.abs(arr[2]-arr[3]);
		newarr[3]=Math.abs(arr[3]-arr[0]);
		return 1+diffy(newarr);
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("wojtek.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
		     int[] numarr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		     System.out.println("Case #"+(i+1)+": "+diffy(numarr));
		}
	}
}
