package kgboostcamp_04_04_array;
import java.util.Random;
import java.util.ArrayList;

public class RandomSolution {
	public static void main(String[] args) {
		int loop = 5;
		for(int i=0;i<loop;i++) {
			ArrayList<Integer> lotto = makeLotto();
			System.out.print("로또 자동 번호 : ");
			for(int j=0; j<lotto.size(); j++) {
				System.out.print(lotto.get(j) + " ");
			}
			System.out.println();
		}
	}
	public static ArrayList<Integer> makeLotto() {
		Random rand = new Random();
		int l = 6;
		int range = 46;
		ArrayList<Integer> result = new ArrayList<>();
		
		while(result.size()<l) {
			int n = rand.nextInt(range);
			if(!result.contains(n)) {
				result.add(n);
			}
		}
		return result;
	}
}