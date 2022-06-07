package basketball;

import java.util.Scanner;

// ���� �󱸸� ������ ������
// ���� �� �޴��ǿ� ���� �Է��� ����
// ���� Menu Ŭ������ �����޾� ����Ѵ�.
public class Player {
	private Menu menu;
	Player(Menu menu){
		this.menu = menu;
	}
	// 1����
	public void oneShoot() {
		System.out.println("1������ �ߴ�.");
		this.menu.addGoalCount();
		this.menu.addScore(Basketball.getOneScore());
		this.menu.addOneShootCount();
	}
	// 2����
	public void twoShoot() {
		System.out.println("2������ �ߴ�.");
		this.menu.addGoalCount();
		this.menu.addScore(Basketball.getTwoScore());
		this.menu.addTwoShootCount();
	}
	// 3����
	public void threeShoot() {
		System.out.println("3������ �ߴ�.");
		this.menu.addGoalCount();
		this.menu.addScore(Basketball.getThreeScore());
		this.menu.addThreeShootCount();
	}
	// �÷��̾ �޴��� ���� ����
	public void showMenu() {
		this.menu.printMenu();
	}
	public static void main(String[] args) {
		Player my = new Player(new Menu());
		Scanner scan = new Scanner(System.in);
		int act = 0;
		while(act != 5) {
			System.out.println("���� ���ұ�??");
			System.out.println("1. 1���� / 2. 2���� / 3. 3���� / 4. �޴����� / 5. ����");
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
				System.out.println("�����մϴ�.");
				break;
			}
			else {
				System.out.println("�� �׷��� �ϴ°� �ƴѵ�..");
			}
		}
	}
}