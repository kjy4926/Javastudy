package kgboostcamp_04_19_oop;

public class MyLinkedList implements MyList {
	
	private int size;
	private Node head;
	private Node tail;
	
	MyLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	// LinkedList는 Index를 통한 접근이 불가능하다.
	// LinkedList에서의 탐색은 언제나 앞에서부터 다음 노드를 확인하여 이동하며 이루어진다.
	// 따라서 LinkedList의 Search 복잡도는 O(N)이된다.
	private Node getNodeByIndex(int index) {
		if(index > this.size) return null;
		Node n = this.head;
		for(int i=0;i<index;i++) {
			n = n.getNext();
		}
		return n;
	}
	
	public int getSize() {
		return this.size;
	}
	
	@Override
	public boolean add(Object o) {
		// TODO Auto-generated method stub
		try {
			if(size == 0) {
				Node n = new Node(o);
				this.head = n;
				this.tail = n;
			}
			else {
				Node n = new Node(o);
				this.tail.setNext(n);
				this.tail = n;
			}
			this.size++;
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	// LinkedList에서 index에 값을 삽인함다 함은 덮어쓰기가 아니다.
	// 해당 노드 사이에 새로운 노드를 삽입하는 것을 의미한다.
	// next 포인터만 수정함으로써 간단하게 삽입이 이루어진다.
	@Override
	public boolean add(int index, Object o) {
		try {
			Node n = getNodeByIndex(index-1);
			Node new_n = new Node(o);
			new_n.setNext(getNodeByIndex(index));
			n.setNext(new_n);
			size++;
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Object get(int index) {
		try {
			Node n;
			n = getNodeByIndex(index);
			return n.getValue();
		} catch (Exception e){
			e.printStackTrace();
			return e.getMessage();
		}
	}
	@Override
	public String toString() {
		String result = "";
		for(int i=0;i<size;i++) {
			result += get(i) + " ";
		}
		return result.trim();
	}
}