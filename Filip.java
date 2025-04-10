import java.io.*;
import java.util.*;

public class Filip {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("filip.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			String[] params = scan.nextLine().split("\\s+");
			String[][] box = new String[Integer.valueOf(params[0])][Integer.valueOf(params[1])];
			if(Boolean.valueOf(params[3])) {
				for(int k = 0; k<box.length;k++) {
					for(int j=0; j<box[k].length;j++) {
						box[k][j]=params[2];
					}
				}
			} else {
				for(int k = 0; k<box.length;k++) {
					for(int j=0; j<box[k].length;j++) {
						box[k][j]=" ";
					}
				}
				for(int k = 0;k<box.length;k++) {
					box[k][0]=params[2];
					box[k][box[k].length-1]=params[2];
				}
				for(int k = 0; k<box[0].length;k++) {
					box[0][k]=params[2];
					box[box.length-1][k]=params[2];
				}
			}
			for(String[] s:box) {
				for(String b:s) {
					System.out.print(b);
				}
				System.out.println();
			}
			
		}
	}
}
