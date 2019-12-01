package com.operatestructs.rbtree;

public class RBNode {
	
	private int id;
	private RBNode leftNode;//左节点
	private RBNode rightNode;//右节点
	private String data;
	private RBNode parent;//parent node
	private boolean isRed;

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

	public RBNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(RBNode leftNode) {
		this.leftNode = leftNode;
	}

	public RBNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(RBNode rightNode) {
		this.rightNode = rightNode;
	}

	public RBNode getParent() {
		return parent;
	}

	public void setParent(RBNode parent) {
		this.parent = parent;
	}

	public boolean isRed() {
		return isRed;
	}

	public void setRed(boolean red) {
		isRed = red;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", leftNode=" + leftNode + ", rightNode="
				+ rightNode + ", data=" + data + "]";
	}


}
