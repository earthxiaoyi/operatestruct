package com.operatestructs.tree;

public class Node {
	
	private int id;
	private Node leftNode;//左节点
	private Node rightNode;//右节点
	private String data;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	@Override
	public String toString() {
		return "Node [id=" + id + ", leftNode=" + leftNode + ", rightNode="
				+ rightNode + ", data=" + data + "]";
	}
	public Node(int id, String data) {
		super();
		this.id = id;
		this.data = data;
	}
	public Node() {
		super();
	}
	
}
