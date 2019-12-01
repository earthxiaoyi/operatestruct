package com.leetcode;

/**
 * Created by jiaming on 2018/11/24.
 */
public class SingleLinkList {

    private LinkNode firstNode;

    public void insert(int data){
        LinkNode newNode = new LinkNode(data);
        newNode.setNext(firstNode);
        firstNode = newNode;
    }

    public void displayList(){
        LinkNode currentLink = firstNode;
        while(currentLink.getNext()!=null){
            currentLink.printList();
            currentLink = currentLink.getNext();
        }
    }

    public void reverse(){
        LinkNode head = firstNode;
        LinkNode pre = null;//前一个
        LinkNode next = null;//后一个
        while(head != null){
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        firstNode = pre;
    }

}
