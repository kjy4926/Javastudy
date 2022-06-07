package kgboostcamp_04_13;

import java.util.Arrays;

public class MyArray {
	private int[] arr;
	private int length;
	private static final int DEFAULTSIZE = 5;
	
	// default constructor -> 길이 5 배열 생성
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
	// 원본에 영향을 주지 않기 위해 Deep Copy
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
	// 배열 참조 반환
	public int[] getArray() {
		return this.arr;
	}
	// 해당 인덱스의 값 반환
	public int getValueByIndex(int idx) {
		if(idx >= this.length) {
			System.out.println("Error : IndexOutOfBoundsException");
			return 0;
		}
		else return this.arr[idx];
	}
	// 배열의 길이 반환
	public int getLength() {
		return this.length; 
	}
	
	public static void main(String[] args) {
		int[] testarr = {1,2,3,4,5};
		MyArray myarr = new MyArray();
		MyArray myarr2 = new MyArray(10);
		// 초기화
		System.out.println("init");
		System.out.println(Arrays.toString(myarr.getArray()));
		System.out.println(Arrays.toString(myarr2.getArray()));
		// 배열 set 테스트
		System.out.println("set array");
		myarr.setArray(testarr);
		myarr2.setArray(new int[]{9,8,7,6,5,4,3,2,1});
		System.out.println(Arrays.toString(myarr.getArray()));
		System.out.println(Arrays.toString(myarr2.getArray()));
		// value set 테스트
		System.out.println("set value");
		myarr.setValueByIndex(3, 9);
		myarr2.setValueByIndex(5, 0);
		System.out.println(Arrays.toString(myarr.getArray()));
		System.out.println(Arrays.toString(myarr2.getArray()));
		// get value 테스트
		System.out.println("get value by index");
		System.out.println(myarr.getValueByIndex(3));
		System.out.println(myarr2.getValueByIndex(6));
		// get length 테스트
		System.out.println("get length");
		System.out.println(myarr.getLength());
		System.out.println(myarr2.getLength());
	}
}