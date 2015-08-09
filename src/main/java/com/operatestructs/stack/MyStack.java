package com.operatestructs.stack;

public class MyStack {
	private Object[] datas;
	private int topIndex = -1;
	
	public MyStack(int length){
		datas = new Object[length];
		
	}
	
	/**
	 * 入栈
	 * @param d
	 */
	public void push(Object d){
		this.topIndex++;
		this.datas[topIndex] = d;
	}
	
	/**
	 * 瞧一瞧，栈顶元素
	 * @return
	 */
	public Object peek(){
		return datas[topIndex];
	}
	
	//出栈
	public Object pop(){
		Object ret = datas[topIndex];
		topIndex--;
		return ret;
	}
	
	public boolean isEmpty(){
		return topIndex==-1;
	}
	
	public boolean isFull(){
		return topIndex==(datas.length-1);
	}
}
