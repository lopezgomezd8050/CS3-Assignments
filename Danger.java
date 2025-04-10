import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Danger {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("danger.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		TreeMap<Integer, String> schedule = new TreeMap<>();
		for(int i = 0; i<test_cases;i++) {
			String[] unparsed = scan.nextLine().split("\\s+");
			String[] alsounparsed = unparsed[0].split("[:]");
			Integer time = 60*Integer.valueOf(alsounparsed[0])+Integer.valueOf(alsounparsed[1]);
			schedule.put(time, unparsed[0]+" "+unparsed[1]);
		}
		for(String vals: schedule.values()) {
			System.out.println(vals);
		}
	}
}