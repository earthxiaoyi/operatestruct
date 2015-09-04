package com.operatestructs.linklist;

public class LinkNode2 {
	private int id;
	private LinkNode2 next;
	
	public LinkNode2(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LinkNode2 getNext() {
		return next;
	}
	public void setNext(LinkNode2 next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "LinkNode [id=" + id + ", next=" + next + "]";
	}
	public LinkNode2(int id, LinkNode2 next) {
		super();
		this.id = id;
		this.next = next;
	}
	public LinkNode2() {
		super();
	}
	
	public void printList(){
		if(this.next!=null){
			System.out.println("id="+id+" , "+"next="+this.next.getId());
		}
	}
	
	
}
