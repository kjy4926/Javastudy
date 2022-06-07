package basketball;

// 메뉴판 정보를 가지고 있는 클래스
// 점수 저장 및 점수 출력 기능을 수행
public class Menu {
	private int score;
	private int goalCount;
	private int oneScoreCount;
	private int twoScoreCount;
	private int threeScoreCount;
	
	Menu(){
		this.score = 0;
		this.goalCount = 0;
		this.oneScoreCount = 0;
		this.twoScoreCount = 0;
		this.threeScoreCount = 0;
	}
	public void printMenu() {
		System.out.println("-------------------");
		System.out.printf("%s ㅣ %s ㅣ %s ㅣ\n", "_____", "__골", " 점수");
		System.out.printf("%5s ㅣ %03d ㅣ %03d ㅣ\n", 1, this.getOneShootCount(), this.getOneShootCount());
		System.out.printf("%5s ㅣ %03d ㅣ %03d ㅣ\n", 2, this.getTwoShootCount(), this.getTwoShootCount()*Basketball.getTwoScore());
		System.out.printf("%5s ㅣ %03d ㅣ %03d ㅣ\n", 3, this.getThreeShootCount(), this.getThreeShootCount()*Basketball.getThreeScore());
		System.out.printf("%s ㅣ %03d ㅣ %03d ㅣ\n", "total", this.getGoalCount(), this.getScore());
		System.out.println("-------------------");
	}
	// setter
	public void addScore(int score) {
		this.score += score;
	}
	public void addGoalCount() {
		this.goalCount += 1;
	}
	public void addOneShootCount() {
		this.oneScoreCount += 1;
	}
	public void addTwoShootCount() {
		this.twoScoreCount += 1;
	}
	public void addThreeShootCount() {
		this.threeScoreCount += 1;
	}
	// getter
	public int getScore() {
		return this.score;
	}
	public int getGoalCount() {
		return this.goalCount;
	}
	public int getOneShootCount() {
		return this.oneScoreCount;
	}
	public int getTwoShootCount() {
		return this.twoScoreCount;
	}
	public int getThreeShootCount() {
		return this.threeScoreCount;
	}
}