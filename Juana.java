import java.io.*;
import java.util.*;

public class Juana {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("juana.dat"));
		int test_num = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_num;i++) {
			//create array based on values in the .dat
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int[][] arr = new int[rows][cols];
			//populate the array
			for(int r = 0; r<rows;r++) {
				for(int c = 0; c<cols;c++) {
					arr[r][c]=scan.nextInt();
				}
				scan.nextLine();
			}
			//find out the sub array
			int tl_row = scan.nextInt()-1;  //removing 1 since the array is one indexed
			int tl_col = scan.nextInt()-1;
			int co_c = scan.nextInt();
			int co_r = scan.nextInt();
			if(arr.length>=tl_row+co_r && arr[0].length>=tl_col+co_c) { // makes sure its not out of bounds r anything
				System.out.println("Test case #"+(i+1)+":");
				for(int r = tl_row; r<tl_row+co_r; r++) {
					System.out.print("    ");
					for(int c = tl_col; c<tl_col+co_c; c++) {
						System.out.print(arr[r][c]+" ");
					}
					System.out.println();
				}
			} else {
				System.out.println("Test case #"+(i+1)+": Unable to extract requested size!");
			}
			System.out.println("--------------------");
		}
	}
}