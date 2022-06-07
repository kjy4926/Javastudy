package kgboostcamp_04_05_sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sort {
	// ��� ������ ���������� �������� �ۼ��Ͽ���.
	// ���� ����
	public static int[] bubbleSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	// ���� ����
	public static int[] insertionSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int key = arr[i];
			int j = i-1;
			// ������ �ڸ�ã��
			// key������ ������ ������ �������� ��ĭ�� �о�� �ݺ�
			while(j >= 0 && key < arr[j]) {
				arr[j+1] = arr[j];
				j-=1;
			}
			arr[j+1] = key;
		}
		return arr;
	}
	// ���� ����
	public static int[] selectionSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			int min = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		return arr;
	}
	// ���� ����
	public static int[] mergeSort(int[] arr) {
		if(arr.length == 1) {
			return arr;
		}
		int mid = arr.length/2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		int i = 0;
		int l = 0;
		int r = 0;
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		while(l<left.length && r<right.length) {
			if(left[l] < right[r]) {
				arr[i] = left[l];
				l++;
			}
			else {
				arr[i] = right[r];
				r++;
			}
			i++;
		}
		
		while(l<left.length) {
			arr[i] = left[l];
			l++;
			i++;
		}
		while(r<right.length) {
			arr[i] = right[r];
			r++;
			i++;
		}
		return arr;
	}
	// �� ����
	public static int[] quickSort(int[] arr, int left, int right) {
		// ���̰� 1�̸� return
		if(right - left < 0) {
			return arr;
		}
		int pivot = right; // ���Ǽ��� ���� right�� pivot���� ����
		int i = left;
		// pivot ���� ���� ���� �������� ��Ƶд�.
		for(int j=left; j<right; j++) {
			if(arr[j] < arr[pivot]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		int temp = arr[i];
		arr[i] = arr[pivot];
		arr[pivot] = temp;
		
		quickSort(arr, left, i-1);
		quickSort(arr, i+1, right);
		
		return arr;
	}
	// �� ����
	public static int[] heapSort(int[] arr) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int i=0;i<arr.length;i++) {
			minHeap.add(arr[i]);
		}
		for(int i=0;i<arr.length;i++) {
			arr[i] = minHeap.poll();
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = {2,5,4,6,7,3,1,9,8};
		System.out.print("Bubble : " + Arrays.toString(bubbleSort(arr.clone())) + "\n");
		System.out.print("Insert : " + Arrays.toString(insertionSort(arr.clone())) + "\n");
		System.out.print("Select : " + Arrays.toString(selectionSort(arr.clone())) + "\n");
		System.out.print("Merge  : " + Arrays.toString(mergeSort(arr.clone())) + "\n");
		System.out.print("Quick  : " + Arrays.toString(quickSort(arr.clone(), 0, arr.length-1)) + "\n");
		System.out.print("Heap   : " + Arrays.toString(heapSort(arr.clone())) + "\n");
		System.out.println("Origin : " + Arrays.toString(arr));
	}
}
