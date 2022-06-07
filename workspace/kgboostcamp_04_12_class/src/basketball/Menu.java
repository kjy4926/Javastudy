package basketball;

// �޴��� ������ ������ �ִ� Ŭ����
// ���� ���� �� ���� ��� ����� ����
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
		System.out.printf("%s �� %s �� %s ��\n", "_____", "__��", " ����");
		System.out.printf("%5s �� %03d �� %03d ��\n", 1, this.getOneShootCount(), this.getOneShootCount());
		System.out.printf("%5s �� %03d �� %03d ��\n", 2, this.getTwoShootCount(), this.getTwoShootCount()*Basketball.getTwoScore());
		System.out.printf("%5s �� %03d �� %03d ��\n", 3, this.getThreeShootCount(), this.getThreeShootCount()*Basketball.getThreeScore());
		System.out.printf("%s �� %03d �� %03d ��\n", "total", this.getGoalCount(), this.getScore());
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