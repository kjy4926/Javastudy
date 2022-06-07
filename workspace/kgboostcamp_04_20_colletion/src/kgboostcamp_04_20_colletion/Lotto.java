package kgboostcamp_04_20_colletion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Lotto {
	HashSet<Integer> lotto;
	
	Lotto(){
		this.lotto = makeLotto();
	}
	
	public static HashSet<Integer> makeLotto() {
		Random rand = new Random();
		HashSet<Integer> result = new HashSet<Integer>();
		while(result.size()<6) {
			int n = rand.nextInt(45)+1;
			result.add(n);
		}
		return result;
	}
	
	public HashSet<Integer> getLotto(){
		return this.lotto;
	}
	
	public static void main(String[] args) {
		Lotto mylotto = new Lotto();
		System.out.println(Arrays.toString(mylotto.getLotto().toArray()));
	}
}