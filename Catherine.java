import java.io.*;
import java.util.*;

public class Catherine {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("catherine.dat"));
		int test_num = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_num;i++) {
			String[] unpar = scan.nextLine().split(" ");
			char[] w1 = unpar[0].toCharArray();
			char[] w2 = unpar[1].toCharArray();
			for(int j = 0; j<w1.length;j++) {
				if(w1[j]==w2[j]) {
					System.out.print(String.valueOf(w1[j]).toUpperCase());
				} else if(String.valueOf(w1).contains(String.valueOf(w2[j]))) {
					System.out.print(w2[j]);
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
