import java.io.*;
import java.util.*;

public class Noah {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("noah.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		String[] dataset = new String[test_cases];
		Map<String,Integer> make = new TreeMap<>();
		Map<String,Integer> model = new TreeMap<>();
		Map<Integer,Integer> year = new TreeMap<>();
		for(int i = 0; i<test_cases;i++) {
			String metaunparsed = scan.nextLine();
			dataset[i]=metaunparsed;
			String[] unparsed = metaunparsed.split(",");
			if(make.get(unparsed[0])==null) {
				make.put(unparsed[0], 1);
			} else {
				int val = make.get(unparsed[0]);
				make.put(unparsed[0], ++val);
			}
			
			if(model.get(unparsed[1])==null) {
				model.put(unparsed[1], 1);
			} else {
				int val = model.get(unparsed[1]);
				model.put(unparsed[1], ++val);
			}
			
			if(year.get(Integer.valueOf(unparsed[2]))==null) {
				year.put(Integer.valueOf(unparsed[2]), 1);
			} else {
				int val = year.get(Integer.valueOf(unparsed[2]));
				year.put(Integer.valueOf(unparsed[2]), ++val);
			}
		}
		Arrays.sort(dataset);
		System.out.println("---Data Sorted---");
		for(String s: dataset) {
			System.out.println(s.replace(",", " "));
		}
		System.out.println();
		
		System.out.println("---Make Breakdown---");
		for(String s: make.keySet()) {
			System.out.println(s+": "+make.get(s));
		}
		System.out.println();
		
		System.out.println("---Model Breakdown---");
		for(String s: model.keySet()) {
			System.out.println(s+": "+model.get(s));
		}
		System.out.println();
		
		System.out.println("---Year Breakdown---");
		for(int s: year.keySet()) {
			System.out.println(s+": "+year.get(s));
		}
		
	}
}
