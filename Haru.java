import java.io.*;
import java.util.*;

public class Haru {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("haru.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			//getting info from file
			int len_instruct = Integer.parseInt(scan.nextLine());
			int px1 = scan.nextInt();	
			int py1 = scan.nextInt();	
			char[] sp1 = scan.nextLine().split(" ")[1].toCharArray(); //split to remove whitespace
			int px2 = scan.nextInt();
			int py2 = scan.nextInt();
			char[] sp2 = scan.nextLine().split(" ")[1].toCharArray();
			//grid et such
			int[][] griddy = new int[9][9]; //culturally significant
			griddy[px1][py1] = 1;
			griddy[px2][py2] = 2;
			boolean pc1=false;
			boolean pc2=false;
			boolean headonedgecase=false; //head on edge case
			for(int j = 0; j<len_instruct; j++) {
				//set previous square to a spike (-1)
				griddy[px1][py1] = -1;
				griddy[px2][py2] = -1;
				//to prepare for edgecase; the 8 ints could be condensed into 4 int[2]s but eh
				int prevpx1=px1;
				int prevpy1=py1;
				int prevpx2=px2;
				int prevpy2=py2;
				//movement handling
				switch(sp1[j]) {
				case 'R':
					px1++;
					break;
				case 'L':
					px1--;
					break;
				case 'U':
					py1++;
					break;
				case 'D':
					py1--;
					break;
				}
				switch(sp2[j]) {
				case 'R':
					px2++;
					break;
				case 'L':
					px2--;
					break;
				case 'U':
					py2++;
					break;
				case 'D':
					py2--;
					break;
				}
				if(prevpx1==px2 && prevpy1==py2 && prevpx2==px1 && prevpy2==py1) { //to check for the edgecase where they like jump over eachother
					headonedgecase=true;
				}
				if(griddy[px1][py1]==0) {
					griddy[px1][py1] = 1;
				} else if (griddy[px1][py1]==-1) {
					pc1=true;
				}
				if(griddy[px2][py2]==0) {
					griddy[px2][py2] = 2;
				} else if (griddy[px2][py2]==-1) {
					pc2=true;
				}
			}
			//aftermathchecking
			if ((griddy[px2][py2]==1 || griddy[px1][py1]==2) || headonedgecase) {
				System.out.println("HEAD ON");
			} else if(pc1 && pc2) {
				System.out.println("DOUBLE SPIKE");
			} else if(pc1) {
				System.out.println("P2 WIN");
			} else if (pc2) {
				System.out.println("P1 WIN");
			} else {
				System.out.println("DRAW");
			}

			if (i == 5) { //debugging
				for(int[] g1: griddy) {
					for(int g2: g1) {
						System.out.print(g2+" ");
					}
					System.out.println();
				}
			}

		}
	}
}
