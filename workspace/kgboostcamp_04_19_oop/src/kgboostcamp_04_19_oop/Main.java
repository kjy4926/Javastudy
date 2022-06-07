package kgboostcamp_04_19_oop;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ArrayList
		System.out.println("ArrayList Test");
		MyArrayList arrlis = new MyArrayList();
		arrlis.add(1);
		arrlis.add(2);
		arrlis.add(3);
		arrlis.add(4);
		arrlis.add(5);
		arrlis.add(6);
		System.out.println(arrlis.toString());
		System.out.println(arrlis.get(3));
		System.out.println(arrlis.get(5));
		System.out.println("4¹ø ÀÎµ¦½º¿¡ 7 »ğÀÔ");
		arrlis.add(4, 7);
		System.out.println(arrlis.toString());
		
		// LinkedList
		System.out.println("Linked List Test");
		MyLinkedList lis = new MyLinkedList();
		lis.add(1);
		lis.add(3);
		lis.add(2);
		lis.add(6);
		lis.add(5);
		lis.add(4);
		System.out.println(lis.get(0));
		System.out.println(lis.get(3));
		System.out.println(lis.get(5));
		System.out.println(lis.toString());
		System.out.println("3¹ø ÀÎµ¦½º¿¡ 8 »ğÀÔ");
		lis.add(3, 8);
		System.out.println(lis.get(3));
		System.out.println(lis.get(4));
		System.out.println(lis.toString());
	}
}
