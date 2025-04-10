import java.io.*;
import java.util.*;

public class Emmanuel {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("emmanuel.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			Map<String, Integer> hashy = new HashMap<>();
			String[] unparsed = scan.nextLine().replace("{", "").replace("}", "").replace(",", " ").split("\\s+");
//			System.out.println(Arrays.toString(unparsed));
			for(String s: unparsed) {
				if(hashy.get(s)==null) {
					hashy.put(s,1);
				} else {
					int count = hashy.get(s)+1;
					hashy.put(s, count);
				}
			}
//			System.out.println(hashy);
			int max=0;
			String val = "";
			for(String s:hashy.keySet()) {
				if(hashy.get(s)>max) {
					max=hashy.get(s);
					val=s;
				}
			}
			System.out.println(val+" appeared "+max+" times(s)");
		}
	}
}
