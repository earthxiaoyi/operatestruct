package com.operatestructs.queue;

/**
 * 演示可循环的队列
 */
public class MyQueue {
	
	private int[] queue;//存放数据的数组
	private int front;//记录队头的索引位置
	private int end; //	记录队尾的索引位置
	private int nItems;//记录当前队列里面存放的元素个数
	
	public MyQueue(int length){
		this.queue = new int[length];
		this.front = 0;
		this.end = -1;
		this.nItems = 0;
	}
	
	public boolean isEmpty(){
		
		return nItems==0;
	}
	
	public boolean isFull(){
		return nItems==queue.length;
	}
	
	public void insert(int data){
		//判断是否到达最大索引项
		if(end==(queue.length-1)){
			end = -1;
		}
		end++;
		queue[end] = data;
		nItems++;
		
		if(nItems>queue.length){
			nItems = queue.length;
		}
	}
	
	public int peekFront(){
		return queue[front];
	}
	
	/**
	 * 移除队列中的元素
	 * @return
	 */
	public int remove(){
		if(nItems==0){
			return 0;
		}
		int temp = queue[front];
		queue[front] = 0;
		//维护front队头
		if(front == queue.length-1){
			front = 0;
		}
		front++;
		nItems--;
		return temp;
	}
}
