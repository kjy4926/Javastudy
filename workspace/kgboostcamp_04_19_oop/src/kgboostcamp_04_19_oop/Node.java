package kgboostcamp_04_19_oop;

public class Node {
	private Object value;
	private Node next;
	
	Node(Object o){
		this.value = o;
		this.next = null;
	}
	public void setNext(Node n) {this.next = n;}
	public Node getNext() {return this.next;}
	public Object getValue() {return this.value;}
}