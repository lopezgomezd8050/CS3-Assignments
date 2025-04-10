import java.io.*;
import java.util.*;

public class pr74 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr74.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
      String[] stringylist = scan.nextLine().split("\\s+");
      for(int j = 0; j<stringylist.length;j++){
        String newStr="";
        if(j%2==0) { //reverse
          for(int k = stringylist[j].length(); k>0;k--){
            newStr+=stringylist[j].charAt(k-1);
          }
        } else { //cyclic
          // newStr+="test";
          for(int k = 0; k<j;k++){
            newStr+=stringylist[j];
          }
        }
        System.out.print(newStr+" ");
      }
      System.out.println();
      // System.out.println(Arrays.toString(stringylist));
		}
	}
}
