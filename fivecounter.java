import java.io.*;
import java.util.*;

public class fivecounter {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("fcounter.dat"));
		while(scan.hasNext()) {
			int inty = Integer.valueOf(scan.nextLine());
			int sum = 0;
			for(int i = 0; i<inty;i++) {
				if(String.valueOf(i).contains("5")) {
					sum+=String.valueOf(i).replaceAll("[^5]", "").length();
				}
			}
			System.out.println(sum);
		}
	}
}
