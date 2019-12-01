package com.linkedlist;

/**
 * 几个小技巧
 * 我经常用来检查链表代码是否正确的边界条件有这样几个：
 * 如果链表为空时，代码是否能正常工作？
 * 如果链表只包含一个结点时，代码是否能正常工作？
 * 如果链表只包含两个结点时，代码是否能正常工作？
 * 代码逻辑在处理头结点和尾结点的时候，是否能正常工作？
 * <p>
 * 题目：
 * 1.单链表反转
 * 2.链表中环的检测
 * 3.两个有序的链表合并
 * 4.删除链表倒数第 n 个结点
 * 5.求链表的中间结点
 */
public class SinglyLinkedList {

    private Node head = null;

    public void insertToHead(int data) {
        Node node = new Node(data, null);
        insertToHead(node);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public Node findByValue(int data) {
        Node p = head;
        while (p != null && p.getData() != data) {
            p = p.getNext();
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.getNext();
            ++pos;
        }
        return p;
    }

    /**
     * 在尾部插入
     *
     * @param data
     */
    public void insertTail(int data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.getNext() != null) {
                p = p.getNext();
            }
            p.setNext(newNode);
        }
    }

    /**
     * 在p节点后插入
     *
     * @param p
     * @param data
     */
    public void insertAfter(Node p, int data) {
        Node newNode = new Node(data, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p != null) {
            newNode.setNext(p.getNext());
            p.setNext(newNode);
        }
    }

    public void insertBefore(Node p, int data) {
        Node newNode = new Node(data, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p != null) {

            //找到p节点的上一个节点
            Node q = head;
            while (q != null && q.getNext() != p) {
                q = q.getNext();
            }
            //如果q是null
            if (q == null) {
                return;
            }
            newNode.setNext(p);
            q.setNext(newNode);
        }
    }

    public void deleteByNode(Node p) {
        //判断头、删除的节点是否为null
        if (head == null || p == null) {
            return;
        }

        //要删除的是头节点
        if (head == p) {
            head = head.getNext();
            return;
        }

        Node q = head;
        while (q != null && q.getNext() != p) {
            q = q.getNext();
        }

        if (q == null) {
            return;
        }

        q.setNext(q.getNext().getNext());
    }

    public void deleteByValue(int data) {
        if (head == null) {
            return;
        }

        if (head.getData() == data) {
            head = head.getNext();
            return;
        }

        Node p = head;
        while (p != null && p.getNext().getData() != data) {
            p = p.getNext();
        }

        //未找到要删除的节点
        if (p == null) {
            return;
        }
        p.setNext(p.getNext().getNext());
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.getData() + ",");
            p = p.getNext();
        }
        System.out.println();
    }

    /**
     * 链表反转
     * 1 -> 2 -> 3 -> 4 -> null
     * null <- 1 <- 2 <- 3 <- 4
     */

    public Node reverseLinkedList() {
        if (head == null) {
            return null;
        }
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node temp = current.getNext();
            current.setNext(prev);
            prev = current;
            current = temp;
        }
        return prev;
    }


}

class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}