import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; 

public class Wash {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("wash.dat"));
		while(scan.hasNext()) {
			System.out.println(LocalDate.parse(scan.nextLine(),DateTimeFormatter.ofPattern("M/d/uuuu")).getDayOfWeek().toString()=="SUNDAY"?"Good to GO":"Not a great idea you foolish insect");
		}
	}
}
