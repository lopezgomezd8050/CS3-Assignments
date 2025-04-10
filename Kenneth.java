import java.io.*;
import java.util.*;

public class Kenneth {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("kenneth.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			//parsing sudoku board
			int[][] sudoku = new int [9][];
			final int[] sortedlist = {1,2,3,4,5,6,7,8,9};
			for(int j=0;j<9;j++) {
				String[] unparsed = scan.nextLine().split("\\s+");
				int[] temp = new int[9];
				for(int k = 0; k<unparsed.length;k++) {
					temp[k]=Integer.parseInt(unparsed[k]);
				}
				sudoku[j]=temp;
			}
			//finding errors
			String errorrows="";
			String errorcols="";
			for(int r = 0; r<9;r++) {
				int[] temp = sudoku[r].clone();
				Arrays.sort(temp);
				if(!Arrays.equals(temp, sortedlist)) {
					errorrows+=" "+(r+1);
				}
				int[] coltemp = new int[9];
				for(int c = 0;c<9;c++) {
					coltemp[c]=sudoku[c][r];
				}
				Arrays.sort(coltemp);
				if(!Arrays.equals(coltemp, sortedlist)) {
					errorcols+=" "+(r+1);
				}
			}
//			System.out.println(errorrows);
//			System.out.println(errorcols);
			if((errorrows+errorcols).equals("")) {
				System.out.println("GRID #"+(i+1)+": SOLUTION IS CORRECT");
			} else {
				String row = errorrows.equals("")?"NONE":errorrows;
				String col = errorcols.equals("")?"NONE":errorcols;
				System.out.println(">> ROWS WITH ERRORS:"+row);
				System.out.println(">> COLUMNS WITH ERRORS:"+col);
			}
			System.out.println("=".repeat(12));
		}
	}
}
