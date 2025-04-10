import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

public class Dominik {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("dominik.dat"));
		HashMap<String,LocalDate> chronos = new HashMap<>();
		String[] unparsedTests = scan.nextLine().split("\\s+");
		int numEvents = Integer.valueOf(unparsedTests[0]);
		int numComparisons = Integer.valueOf(unparsedTests[1]);
		for(int i = 0; i<numEvents; i++) {
			String[] unparsed = scan.nextLine().split("\\s+");
			if(unparsed[0].contains("0000")) { //year zero checker
				unparsed[0]="0001"+unparsed[0].substring(4);
			}	
			LocalDate date = LocalDate.parse(unparsed[0],DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			String event="";
			for(int k = 1;k<unparsed.length;k++) {
				event+=unparsed[k]+" ";
			}
			event=event.substring(0,event.length()-1); // lagging space fix
			chronos.put(event,date);
			
		}
		for(int i = 0; i<numComparisons;i++) {
			String[] unparsed = scan.nextLine().split("[:]");
			long days = Math.abs(ChronoUnit.DAYS.between(chronos.get(unparsed[0]), chronos.get(unparsed[1])));
			if(String.valueOf(chronos.get(unparsed[0])).contains("0001") ||String.valueOf(chronos.get(unparsed[1])).contains("0001")) { //year zero adjuster
				days+=365;
			}
			System.out.printf("%,d",days);
			System.out.println();
		}
	}
}
