package com.operatestructs.linklist2;

public class DoubleLinkList {
	
	private Node2 last;
	private Node2 first;
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public Node2 peekFirst(){
		return first;
	}
	
	public void insertFirst(int id){
		Node2 newLink = new Node2(id);
		//如果链表没有node
		if(isEmpty()){
			last = newLink;
		}else{
			//新进来的node成为first的上个结点
			first.setPrivious(newLink);
		}
		newLink.setNext(first);//first成为新Node的下个结点
		first = newLink;//新老替换
	}
	
	public void insertLast(int id){
		Node2 newLink = new Node2(id);
		if(isEmpty()){
			first = newLink;
		}else{
			last.setNext(newLink);//设置last下个结点为新node
			newLink.setPrivious(last);
		}
		last = newLink;
	}
	
	public Node2 removeFirst(){
		//首先next结点置为first，privious置为空
		Node2 temp = first;
		if(first.getNext()==null){
			last = null;
		}else{
			temp.getNext().setPrivious(null);
		}
		first = first.getNext();
		return temp;
	}
	
	public Node2 removeLast(){
		Node2 temp = last;
		if(last.getPrivious()==null){
			first = null;
		}else{
			last.getPrivious().setNext(null);
		}
		last = last.getPrivious();
		return temp;
	}
	
	public boolean insertAfter(int key,int id){
		
		return false;
	}
	
	/**
	 * 任意位置的删除
	 * @param id
	 * @return
	 */
	public Node2 remove(int id){
		/**
		 * 1:先找到删除的结点
		 * 2:如果这个结点是first，那么就把它的next作为新的first
		 * 2.1否则就把这个结点的privious结点的next，设置成为这个结点的next
		 * 3:如果这个结点是last，那么就把它的privious结点置为last
		 * 3.1 否则就把这个结点的next结点的privious结点，设置成为这个结点的privious
		 */
		
		return null;
	}
	
	public Node2 find(int id){
		return null;
	}
}
