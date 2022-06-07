package basketball;

import java.util.Scanner;

// 실제 농구를 수행할 행위자
// 슈팅 및 메뉴판에 점수 입력을 수행
// 따라서 Menu 클래스를 참조받아 사용한다.
public class Player {
	private Menu menu;
	Player(Menu menu){
		this.menu = menu;
	}
	// 1점슛
	public void oneShoot() {
		System.out.println("1점슛을 했다.");
		this.menu.addGoalCount();
		this.menu.addScore(Basketball.getOneScore());
		this.menu.addOneShootCount();
	}
	// 2점슛
	public void twoShoot() {
		System.out.println("2점슛을 했다.");
		this.menu.addGoalCount();
		this.menu.addScore(Basketball.getTwoScore());
		this.menu.addTwoShootCount();
	}
	// 3점슛
	public void threeShoot() {
		System.out.println("3점슛을 했다.");
		this.menu.addGoalCount();
		this.menu.addScore(Basketball.getThreeScore());
		this.menu.addThreeShootCount();
	}
	// 플레이어가 메뉴를 보는 동작
	public void showMenu() {
		this.menu.printMenu();
	}
	public static void main(String[] args) {
		Player my = new Player(new Menu());
		Scanner scan = new Scanner(System.in);
		int act = 0;
		while(act != 5) {
			System.out.println("나는 뭘할까??");
			System.out.println("1. 1점슛 / 2. 2점슛 / 3. 3점슛 / 4. 메뉴보기 / 5. 종료");
			act = scan.nextInt();
			if(act == 1) {
				my.oneShoot();
			}
			else if(act == 2) {
				my.twoShoot();
			}
			else if(act == 3) {
				my.threeShoot();
			}
			else if(act == 4) {
				my.showMenu();
			}
			else if(act == 5) {
				System.out.println("종료합니다.");
				break;
			}
			else {
				System.out.println("농구 그렇게 하는거 아닌데..");
			}
		}
	}
}