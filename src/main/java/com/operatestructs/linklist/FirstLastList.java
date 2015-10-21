package com.operatestructs.linklist;

/**
 * 演示双端链表
 * @author JM
 *
 */
public class FirstLastList {

	private LinkNode firstNode;
	//记录结尾的节点
	private LinkNode lastNode;
	
	public void insert(int id){
		LinkNode newNode = new LinkNode(id);
		newNode.setNext(firstNode);
		firstNode = newNode;
	}
	
	public LinkNode removeFirst(){
		LinkNode temp = firstNode;
		firstNode = temp.getNext();
		return temp;
	}
	
	public LinkNode find(int id){
		LinkNode node = firstNode;
		//循环递归查找
		while(node.getId()!=id){
			if(node.getNext()!=null){
				node = node.getNext();
			}else{
				return null;
			}
		}
		return node;
	}
	
	public LinkNode remove(int id){
		LinkNode needDelete = firstNode;
		LinkNode previNode = firstNode;
		while(needDelete.getId()!=id){
			if(needDelete.getNext()==null){
				return null;
			}else{
				
				previNode = needDelete;
				needDelete = needDelete.getNext();
			}
		}
		
		if(needDelete.equals(firstNode)){
			firstNode = firstNode.getNext();
		}else{
			previNode.setNext(needDelete.getNext());
		}
		
		return needDelete;
	}
	
	public void displayList(){
		LinkNode node = firstNode;
		while(node != null){
			node.printList();
			node = node.getNext();
		}
	}
	
	
	public static void main(String[] args) {
		FirstLastList list = new FirstLastList();
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
