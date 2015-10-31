package com.operatestructs.linklist2;

public class Node2 {
	
	private int id;
	private Node2 next;		//下个结点
	private Node2 privious; //上个结点
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Node2 getNext() {
		return next;
	}
	public void setNext(Node2 next) {
		this.next = next;
	}
	
	public Node2 getPrivious() {
		return privious;
	}
	public void setPrivious(Node2 privious) {
		this.privious = privious;
	}
	
	public Node2(int id){
		this.id=id;
	}
	
	public void printList(){
		String info = "id = "+id;
		if(next!=null){
			info += "next = "+next.getId();
		}
		if(privious!=null){
			info += ",privious = "+privious.getId();
		}
		System.out.println(info);
	}
}
