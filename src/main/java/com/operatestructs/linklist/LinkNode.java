package com.operatestructs.linklist;

public class LinkNode {
	private int id;
	private LinkNode next;
	
	public LinkNode(int id){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LinkNode getNext() {
		return next;
	}
	public void setNext(LinkNode next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "LinkNode [id=" + id + ", next=" + next + "]";
	}
	public LinkNode(int id, LinkNode next) {
		super();
		this.id = id;
		this.next = next;
	}
	public LinkNode() {
		super();
	}
	
	
}
