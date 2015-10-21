package com.operatestructs.linklist;

public class DoubleLinkList {
	private LinkNode2 firstNode;
	private LinkNode2 lastNode;
	public void insert(int id){
	}
	
	public LinkNode removeFirst(){
		return null;
	}
	
	public LinkNode find(int id){
		
		return null;
	}
	
	public LinkNode remove(int id){
		return null;
	}
	
	public void displayList(){
		
	}
	
	
	public static void main(String[] args) {
		DoubleLinkList list = new DoubleLinkList();
		list.insert(1);
		list.insert(6);
		list.insert(21);
		list.insert(2);
		
		list.displayList();
		System.out.println("=-----------");
		list.remove(6);
		list.displayList();
	}
}
