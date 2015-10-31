package com.operatestructs.linklist2;

import com.operatestructs.linklist.LinkNode;

/**
 * 双向链表的实现
 * @author jiaming.jiang
 * 
 */
public class FirstLastLinkList {
	private Node firstNode;//链表头结点
	private Node lastNode; //链表尾节点
	
	public void insertFirst(int id){
		Node newNode = new Node(id);
		if(null == firstNode){
			lastNode = newNode;
		}
		//替换头结点
		newNode.setNext(firstNode);
		firstNode = newNode;
	}
	
	public void insertLast(int id){
		Node newNode = new Node(id);
		if(null == firstNode){
			firstNode = newNode;
		}else{
			lastNode.setNext(newNode);
		}
		lastNode = newNode;
	}
	
	public Node removeFirst(){
		Node temp = firstNode;
		//判断是否到链表结尾
		if(null == firstNode.getNext()){
			lastNode = null;
		}
		firstNode = firstNode.getNext();
		return temp;
	}
	
	public Node remove(int id){
		
		//记录要删除的结点的上个结点
		return null;
	}
	
	public void displayList(){
		Node node = firstNode;
		while(node != null){
			node.printList();
			node = node.getNext();
		}
	}
	
	public Node find(int id){
		
		return null;
	}
	
	
	public static void main(String[] args) {
		FirstLastLinkList d = new FirstLastLinkList();
		d.insertFirst(1);
		d.insertLast(2);
		d.insertFirst(3);
		
		d.displayList();
		System.out.println("==========");
		//d.removeFirst();
		d.displayList();
	}
}
