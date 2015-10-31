package com.operatestructs.linklist2;

public class Node {
	private int id;
	private Node next;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node(int id, Node next) {
		super();
		this.id = id;
		this.next = next;
	}
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Node [id=" + id + ", next=" + next + "]";
	}
	
	public Node(int id){
		this.id=id;
	}
	
	
	public void printList(){
		String info = "id = "+id;
		if(next!=null){
			info += "next = "+next.getId();
		}
		System.out.println(info);
	}
}
