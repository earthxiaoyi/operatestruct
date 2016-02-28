package com.thinkinjava;

public class LinkedList<T> {
	
	private static class Node<T>{
		T item;//当前结点
		Node<T> next;
		Node(){
			this.item = null;
			this.next = null;
		}
		Node(T item,Node<T> next){
			this.item = item;
			this.next = next;
		}
		boolean end(){
			return item==null && next==null;
		}
		@Override
		public String toString() {
			return "Node [item=" + item + ", next=" + next + "]";
		}
	}
	
	private Node<T> top = new Node<T>();
	public void push(T item){
		top = new Node(item,top);
	}
	
	public T pop(){
		T result = top.item;
		//如果top不为空，则取出top里的下个结点数据，赋值给top
		if(!top.end())
			top = top.next;
		return result;
	}
	
	public static void main(String[] args) {
		//链表实现字符串倒序
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.push("1");
		linkedList.push("2");
		linkedList.push("3");
		String s ;
		while((s = linkedList.pop())!=null){
			System.out.println(s);
		}
	}
}
