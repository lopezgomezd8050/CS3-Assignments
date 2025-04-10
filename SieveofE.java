import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

public class SieveofE {
	
	public static boolean[] sieve(int max) {
		boolean[] primes = new boolean[max];
		for(int i = 0; i<primes.length;i++) {
			primes[i]=true;
		}
		for(int i = 2; i < primes.length; i++) {
			if(primes[i]) {
				for(int k = 2*i; k<primes.length;k+=i) {
					primes[k]=false;
				}
			}
			
		}
		return primes;
	}
	
	public static void main(String[] args){
		System.out.println(Arrays.toString(sieve(51)));
		System.out.println(Arrays.toString(sieve(4523)));
		System.out.println(Arrays.toString(sieve(3474)));
		System.out.println(Arrays.toString(sieve(64)));
		System.out.println(Arrays.toString(sieve(4574)));
		System.out.println(Arrays.toString(sieve(700)));

	}
}
