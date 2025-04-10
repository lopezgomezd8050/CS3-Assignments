import java.io.*;
import java.util.*;

public class News {
	public static boolean xthreat(String s) {
		if(s.equals("Magneto")||s.equals("Juggernaut")||s.equals("Apocalypse")||s.equals("Mystique")||s.equals("Sentinels")) {
			return true;
		}
		return false;
	}
	
	public static boolean wthreat(String s) {
		if(s.equals("Thanos")||s.equals("Galactus")||s.equals("Kang")||s.equals("Ultron")||s.equals("Graviton")) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("news.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<test_cases;i++) {
			String[] str = scan.nextLine().split("\\s+");
			String fstring = "Business as Usual.";
			for(String s: str) {
				if(xthreat(s)) {
					fstring="Sharpen Your Claws Wolverine."; //no break here b/c there might be a world villain
				} else if(wthreat(s)) {
					fstring="Calling All Heroes.";
					break;
				}
			}
			System.out.println(fstring);
		}	
	}
}
