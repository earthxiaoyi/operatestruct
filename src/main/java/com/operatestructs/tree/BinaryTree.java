package com.operatestructs.tree;

/**
 * 二叉树
 * @author jiaming.jiang
 */
public class BinaryTree {
	private Node root;
	
	public Node find(int key){
		Node current = root;
		while(current.getId()!=key){
			if(current.getId()>key){
				current = current.getLeftNode();
			}else if(current.getId()<key){
				current = current.getRightNode();
			}
			if(current==null){
				return null;
			}
		}
		return current;
	}
	
	public void insert(int id,String data){
		//1.创建新节点
		Node newNode = new Node(id,data);
		if(root==null){
			root = newNode;
		}else{
			//2.查找插入位置
			Node current = root;
			Node parent = null;
			while(true){
				parent = current;
				if(id<current.getId()){
					current = current.getLeftNode();
					if(current==null){
						//3.修改节点属性
						parent.setLeftNode(newNode);
						return;
					}
				}else{
					current = current.getRightNode();
					if(current==null){
						//3.修改节点属性
						parent.setRightNode(newNode);
						return;
					}
				}
			}
		}
	}
	
	
}
