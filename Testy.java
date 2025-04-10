import java.io.*;
import java.util.*;

public class Testy {
	public static void main(String[] args) {
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		int x = 0; 
		int cnt = 0;
		for(int r=0; r<mat.length;r++) {
			System.out.println(r);
			for(int c=0;c<mat[r].length;c++) {
				System.out.println(c);
				x+= mat[r][c];
				cnt++;
			}
			System.out.println();
		}
		System.out.println(x/cnt);
	}
}
