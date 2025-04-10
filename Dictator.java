import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Dictator {
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
		Scanner scan = new Scanner(new File("dictator.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			int maxWeight = Integer.parseInt(scan.nextLine());
			int[] weights = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(a->Integer.parseInt(a)).toArray();
			int[] values = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(a->Integer.parseInt(a)).toArray();
			Map<Integer, Integer> weightValueChart = new HashMap<>();
			for(int k = 0; k<weights.length;k++) {
				weightValueChart.put(weights[k], values[k]);
			}
			int[][] powerWeights = powerlist(weights);
			int maxValue = 0;
			for(int[] w: powerWeights) {
				if(IntStream.of(w).sum()<=maxWeight) {
					int sum = 0;
					for(int k = 0; k<w.length;k++) {
						sum+=weightValueChart.get(w[k]);
					}
					if(sum>maxValue) {
						maxValue=sum;
					}
				}
			}
			System.out.println(maxValue);

		}
	}
}