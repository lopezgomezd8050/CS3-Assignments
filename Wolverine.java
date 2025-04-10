import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Wolverine {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("wolverine.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			String sdate = scan.nextLine();
			String[] skip = scan.nextLine().split("\\s+");
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate date = LocalDate.parse(sdate,formatter);
			char sw = skip[0].charAt(0);
			switch (sw) {
		    case 'D':
				date=date.plusDays(Integer.valueOf(skip[1]));
		        break;
		    case 'M':
				date=date.plusMonths(Integer.valueOf(skip[1]));
		        break;
		    case 'Y':
				date=date.plusYears(Integer.valueOf(skip[1]));
		        break;
			}
			System.out.print(date.format(DateTimeFormatter.ofPattern("MMMM", Locale.getDefault()))+" ");
			System.out.print(date.format(DateTimeFormatter.ofPattern("dd", Locale.getDefault()))+", ");
			System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy", Locale.getDefault())));

		}
	}
}
