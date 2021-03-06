package com.operatestructs.linklist;

public class SingleLinkList {
	private LinkNode firstNode;
	
	public void insert(int id){
		LinkNode newLink = new LinkNode(id);
		newLink.setNext(firstNode);
		firstNode = newLink;

	}
	
	public LinkNode removeFirst(){
		LinkNode currentLink = firstNode.getNext();
		firstNode = currentLink;
		return currentLink;
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
		LinkNode currentLink = firstNode;
		while(currentLink.getNext()!=null){
			currentLink.printList();
			currentLink = currentLink.getNext();
		}
	}
	
	public static void main(String[] args) {
		SingleLinkList link = new SingleLinkList();
		link.insert(2);
		link.insert(1);
		link.insert(10);
		link.displayList();
		System.out.println("=====");
		link.removeFirst();
		link.displayList();
		System.out.println("-------");
		LinkNode find = link.find(10);
		find.printList();
	}
}
