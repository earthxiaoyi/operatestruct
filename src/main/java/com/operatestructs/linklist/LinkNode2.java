package com.operatestructs.linklist;

public class LinkNode2 {
	private int id;
	private LinkNode2 next;
	private LinkNode2 privous;
	
	public LinkNode2 getPrivous() {
		return privous;
	}

	public void setPrivous(LinkNode2 privous) {
		this.privous = privous;
	}

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
	/**
	 * 打印linkList
	 */
	public void printList(){
		String info = "id = "+id;
		if(next!=null){
			info += "next = "+next.getId();
		}
		if(privous!=null){
			info += "privous = "+next.getId();
		}
		System.out.println(info);
	}
	public LinkNode2(int id, LinkNode2 next) {
		super();
		this.id = id;
		this.next = next;
	}
	public LinkNode2() {
		super();
	}
	
	
}
