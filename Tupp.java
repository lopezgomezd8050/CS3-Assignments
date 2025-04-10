import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Tupp {
	public static int[][] powerlist(int[] list) {
		int[][] plist = new int[(int)Math.pow(2,list.length)-1][];
		for(int i = 1; i < plist.length+1; i++) {
			String unholy = "0".repeat(Integer.toBinaryString(plist.length).length()-Integer.toBinaryString(i).length())+Integer.toBinaryString(i);
			int [] temp = new int[unholy.replace("0", "").length()];
			int ind = 0;
			for(int k = 0; k < unholy.length(); k++) {
				if(unholy.charAt(k)=='1') {
					temp[ind]=list[k];
					ind++;
				}
			}
			plist[i-1]=temp;
		}
		return plist;
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("tupp.dat"));
		int length = Integer.parseInt(scan.nextLine());
		while(scan.hasNext()) {
			int[] parsed = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(a->Integer.parseInt(a)).toArray();
			int sum = IntStream.of(parsed).sum();
			int[][] powerlist = powerlist(parsed);
			boolean isItExactlyPossible=false;
			for(int[] list: powerlist) {
				if(IntStream.of(list).sum()==length) {
					isItExactlyPossible=true;
					break;
				}
			}
			if(isItExactlyPossible) {
				System.out.println("WOW YOU THE WINNER YOU THE BEST WOOOOOOOOOO");
			}else {
				System.out.println(sum>=length?"VIVES":"MUERES");
			}
		}

	}
}
