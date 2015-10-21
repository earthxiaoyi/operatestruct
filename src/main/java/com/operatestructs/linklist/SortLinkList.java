package com.operatestructs.linklist;

/**
 * 演示有序的链表
 * @author jiaming.jiang
 *
 */
public class SortLinkList {
	private LinkNode firstNode;
	
	public void insert(int id){
		LinkNode newLink = new LinkNode(id);
		LinkNode previous = null;
		LinkNode current = firstNode;
		//第一步:找到排序的node
		while(current!=null && id>current.getId()){
			previous = current;
			current = current.getNext();
		}
		//第二部:判断previous是否为空,如果是则把newlink设置成fisrtNode
		if(previous==null){
			firstNode = newLink;
		}else{
			previous.setNext(newLink);
		}
		newLink.setNext(current);
	}
	
	public LinkNode removeFirst(){
		LinkNode currentLink = firstNode.getNext();
		firstNode = currentLink;
		return currentLink;
	}
	
	public LinkNode find(int id){
		LinkNode node = firstNode;
		while(node.getId()!=id){
			if(node.getNext()==null){
				return null;
			}else{
				node = node.getNext();
			}
		}
		return node;
	}
	
	public LinkNode remove(int id){
		
		return null;
	}
	
	public void displayList(){
		LinkNode currentLink = firstNode;
		while(currentLink.getNext()!=null){
			currentLink.printList();
			currentLink = currentLink.getNext();
		}
	}
	
	public static void main(String[] args) {
		SortLinkList link = new SortLinkList();
		link.insert(2);
		link.insert(1);
		link.insert(10);
		link.insert(10);
		link.insert(1056);
		link.insert(102);
		link.insert(1011);
		link.insert(108);
		link.displayList();
		/*System.out.println("=====");
		link.removeFirst();
		link.displayList();
		System.out.println("-------");
		LinkNode find = link.find(10);
		find.printList();*/
	}
}
