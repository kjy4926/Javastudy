package kgboostcamp_04_13;

import java.util.Arrays;

public class MyArray {
	private int[] arr;
	private int length;
	private static final int DEFAULTSIZE = 5;
	
	// default constructor -> ���� 5 �迭 ����
	MyArray(){
		this.arr = new int[DEFAULTSIZE];
		this.length = this.arr.length;
	}
	// constructor
	MyArray(int length){
		this.arr = new int[length];
		this.length = this.arr.length;
	}
	// setter
	// ������ ������ ���� �ʱ� ���� Deep Copy
	public void setArray(int[] arr) {
		this.arr = arr.clone();
		this.length = this.arr.length;
	}
	public void setValueByIndex(int idx, int value) {
		if(idx >= this.length) {
			System.out.println("Error : IndexOutOfBoundsException");
		}
		else this.arr[idx] = value;
	}
	// getter
	// �迭 ���� ��ȯ
	public int[] getArray() {
		return this.arr;
	}
	// �ش� �ε����� �� ��ȯ
	public int getValueByIndex(int idx) {
		if(idx >= this.length) {
			System.out.println("Error : IndexOutOfBoundsException");
			return 0;
		}
		else return this.arr[idx];
	}
	// �迭�� ���� ��ȯ
	public int getLength() {
		return this.length; 
	}
	
	public static void main(String[] args) {
		int[] testarr = {1,2,3,4,5};
		MyArray myarr = new MyArray();
		MyArray myarr2 = new MyArray(10);
		// �ʱ�ȭ
		System.out.println("init");
		System.out.println(Arrays.toString(myarr.getArray()));
		System.out.println(Arrays.toString(myarr2.getArray()));
		// �迭 set �׽�Ʈ
		System.out.println("set array");
		myarr.setArray(testarr);
		myarr2.setArray(new int[]{9,8,7,6,5,4,3,2,1});
		System.out.println(Arrays.toString(myarr.getArray()));
		System.out.println(Arrays.toString(myarr2.getArray()));
		// value set �׽�Ʈ
		System.out.println("set value");
		myarr.setValueByIndex(3, 9);
		myarr2.setValueByIndex(5, 0);
		System.out.println(Arrays.toString(myarr.getArray()));
		System.out.println(Arrays.toString(myarr2.getArray()));
		// get value �׽�Ʈ
		System.out.println("get value by index");
		System.out.println(myarr.getValueByIndex(3));
		System.out.println(myarr2.getValueByIndex(6));
		// get length �׽�Ʈ
		System.out.println("get length");
		System.out.println(myarr.getLength());
		System.out.println(myarr2.getLength());
	}
}