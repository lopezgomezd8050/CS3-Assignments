import java.io.*;
import java.util.*;
public class Grade {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("ivan.dat"));
		int tests=Integer.parseInt(scan.nextLine());
		char[] key = scan.nextLine().toCharArray(); // fancy
		for(int i = 0; i<tests;i++) {
			int cor = 0;
			int incor = 0;
			int total = 0;
			char[] answers = scan.nextLine().toCharArray();
			for(int j = 0; j<answers.length;j++) {
				if (answers[j] == '_') {
					continue;
				}
				else if (answers[j]==key[j]) {
					cor++;
					total++;
				}
				else {
					incor++;
					total++;
				}
			}
			int points = cor*6-incor*2;
			if (total==0) {
				System.out.println("Exam #"+(i+1)+": "+points+" 0.0");
				continue;
			}
			System.out.println("Exam #"+(i+1)+": "+points+" "+String.format("%,.1f",(100*(double)cor/total)));
		}
		
	}

}
