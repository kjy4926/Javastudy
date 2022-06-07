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
	// LinkedList�� Index�� ���� ������ �Ұ����ϴ�.
	// LinkedList������ Ž���� ������ �տ������� ���� ��带 Ȯ���Ͽ� �̵��ϸ� �̷������.
	// ���� LinkedList�� Search ���⵵�� O(N)�̵ȴ�.
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
	// LinkedList���� index�� ���� �����Դ� ���� ����Ⱑ �ƴϴ�.
	// �ش� ��� ���̿� ���ο� ��带 �����ϴ� ���� �ǹ��Ѵ�.
	// next �����͸� ���������ν� �����ϰ� ������ �̷������.
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