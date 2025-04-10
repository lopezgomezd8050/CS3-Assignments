import java.io.*;
import java.util.*;

public class Classes {
	
	int code;
	String name;
	int hours;
	String subject;
	double rating;
	int time; 
	
	public Classes(Integer code, String name, Integer hours, String subject, Double rating, int time) {
		this.code=code;
		this.name=name;
		this.hours=hours;
		this.subject=subject;
		this.rating=rating;
		this.time=time;
	}
	
	public String toString() {
		return this.code+": "+this.name+"\n";
	}
	
	private static int subjectFunc(Classes a, Classes b) { //literally horrible code but its 10 in the morning so eh
		int vala = 0;
		int valb = 0;
		switch(a.subject) {
		case"Writing":
			vala=5;
			break;
		case"Lighting":
			vala=4;
			break;
		case"Sound-Design":
			vala=3;
			break;
		case"Casting":
			vala=2;
			break;
		case"Set-Design":
			vala=1;
			break;
		}
		
		switch(b.subject) {
		case"Writing":
			valb=5;
			break;
		case"Lighting":
			valb=4;
			break;
		case"Sound-Design":
			valb=3;
			break;
		case"Casting":
			valb=2;
			break;
		case"Set-Design":
			valb=1;
			break;
		}
		return vala-valb;
	}
	
	private static int timeFunc(Classes a, Classes b) { // same for this but its even worse this time
		int vala = 0;
		int valb = 0;
		
		if(a.time>=660 && a.time<900) {
			vala=5;
		} else if(a.time>=900 && a.time<1080) {
			vala=4;
		} else if(a.time>=540 && a.time<660) {
			vala=3;
		} else if(a.time>=1080 && a.time<1200) {
			vala=2;
		} else if(a.time>=420 && a.time<540) {
			vala=1;
		}
		
		if(b.time>=660 && b.time<900) {
			valb=5;
		} else if(b.time>=900 && b.time<1080) {
			valb=4;
		} else if(b.time>=540 && b.time<660) {
			valb=3;
		} else if(b.time>=1080 && b.time<1200) {
			valb=2;
		} else if(b.time>=420 && b.time<540) {
			valb=1;
		}
		
		
		return vala-valb;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("classes.dat"));
		int test_cases = Integer.parseInt(scan.nextLine());
		int[] preReq = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(a->Integer.parseInt(a)).toArray();
		ArrayList<Classes> trueClassList = new ArrayList<Classes>();
		a:
		for(int i = 0; i<test_cases;i++) {
			String[] classes = scan.nextLine().split("\\|");
			String classPreReq[] = classes[6].replace(" ","").split("\\,");
			b:
			for(int k = 0; k < classPreReq.length;k++) {
				for(int j = 0; j<preReq.length;j++) {
					if(Integer.parseInt(classPreReq[k])==preReq[j]) {
						continue b;
					}
				}
				continue a;
			}
			trueClassList.add(new Classes(
					Integer.valueOf(classes[0]), 
					classes[1], 
					Integer.valueOf(classes[2]), 
					classes[3], Double.valueOf(classes[4]), 
					Integer.valueOf(classes[5].split("\\:")[0])*60+Integer.valueOf(classes[5].split("\\:")[1])));	
		}

		Comparator<Classes> cSubject = (a,b) -> subjectFunc(a,b);
		Comparator<Classes> cRating = (a,b) -> (int)((a.rating-b.rating)*10);
		Comparator<Classes> cTime = (a,b) -> timeFunc(a,b);
		Comparator<Classes> cHours = (a,b) -> b.hours-a.hours;
		Comparator<Classes> cCode = (a,b) -> a.code-b.code;


		Classes[] finalClassList = trueClassList.toArray(new Classes[trueClassList.size()]);
		Arrays.sort(finalClassList,
				cSubject.thenComparing(
				cRating.thenComparing(
				cTime.thenComparing(
				cHours.thenComparing(
				cCode
				)))));
		
		int credits = 20;
		for(int i = finalClassList.length-1; i>=0;i--) {
			credits-=finalClassList[i].hours;
			if(credits<0) {
				break;
			}
			System.out.println(finalClassList[i]);
		}
		
	}

}
