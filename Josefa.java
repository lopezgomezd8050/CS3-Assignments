import java.io.*;
import java.util.*;

public class Josefa {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("josefa.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			String unparsed = scan.nextLine();
			boolean isneg = unparsed.indexOf("-")!=-1? true:false;
			String strung="";
			int num=Integer.parseInt(unparsed.replace("-", ""));
			if(isneg) {	
				num=256-num;
				strung=Integer.toBinaryString(num);
			} else {
				strung="0".repeat(8-Integer.toBinaryString(num).length())+Integer.toBinaryString(num);
			}
			System.out.println(strung);
		}
	}
}
