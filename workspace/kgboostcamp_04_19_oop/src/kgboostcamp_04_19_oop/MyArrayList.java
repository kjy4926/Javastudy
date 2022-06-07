package kgboostcamp_04_19_oop;

import java.util.Arrays;

public class MyArrayList implements MyList{
	
	private Object[] arr;
	
	MyArrayList() {
		arr = new Object[0];
	}
	
	@Override
	public boolean add(Object o) {
		// TODO Auto-generated method stub
		try {
			arr = Arrays.copyOf(arr, arr.length+1);
			arr[arr.length-1] = o;
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean add(int index, Object o) {
		try {
			// �켱 ���̸� �ø���.
			add(o);
			// ��ĭ�� �ڷ� �δ�.
			for(int i=arr.length-1;i>index;i--) {
				arr[i] = arr[i-1];
			}
			arr[index] = o;
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Object get(int index) {
		try {
			return arr[index];
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}
