package com.operatestructs.arrays.order;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示直接使用数据操作有序数组,可存放重复值
 * 删除相同元素与查找相同元素
 * 
 * 
 */
public class OperateOrderNoIndexRepeatable {
	private int[] datas = null;
	private int currentIndex;

	public OperateOrderNoIndexRepeatable(int length) {
		datas = new int[length];
	}

	/**
	 * 插入元素
	 * 
	 * @param data
	 * @return
	 */
	public int insert(int data) {
		//假设是升序
    	int index=0;
    	//1.查找数据data应该存放的位置；
    	for(index = 0;index<currentIndex;index++){
    		if(datas[index] > data){
    			break;
    		}
    	}
    	//2.把这个位置及其后面的数据向后移动一位
    	//从后往前移动数据
    	for(int i=currentIndex;i>index;i--){
    		datas[i]=datas[i-1];
    	}
    	//3.把data设置到应该存放的位置
    	datas[index] = data;
    	//每增加一个数据索引+1
    	currentIndex++;
        return currentIndex-1;
	}

	public void remove(int data) {
		int index = this.getIndex(0, data);
		//循环向后查找数据
		while (index >= 0) {
			for (int i = index; i < currentIndex; i++) {
				datas[i] = datas[i+1];
			}
			currentIndex--;
			// 再次查找后续对于的索引
			index = this.getIndex(index, data);
		}
	}

	public List<Integer> searchOne(int data) {
		List<Integer> repList = new ArrayList<Integer>();
		int index = this.getIndex(0, data);
		while (index >= 0) {
			// 如果有，则加入repList中
			repList.add(datas[index]);
			// 再次查找后续对于的索引
			index = this.getIndex(index, data);
		}
		return repList;
	}

	/**
	 * 根据参数，从数组中查找索引
	 * 
	 * @param begin
	 *            循环数据的开始位置
	 * @param data
	 * @return
	 */
	private int getIndex(int begin, int data) {
		int index = -1;
		for (int i = begin; i < currentIndex; i++) {
			if (datas[i] == data) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * 打印数组内的元素
	 */
	
	public void printArray(){
		for(int i=0;i<datas.length;i++){
			System.out.print(datas[i]+",");
		}
		System.out.println("");
	}
	
	
	public static void main(String args[]){
		OperateOrderNoIndexRepeatable t = new OperateOrderNoIndexRepeatable(20);
		t.insert(1);
		t.insert(2);
		t.insert(2);
		t.insert(3);
		t.insert(4);
		t.insert(5);
		t.insert(10);
		//第一次打印
		System.out.println("第一次打印======");
		t.printArray();
		//删除后打印
		System.out.println("删除后打印======");
		t.remove(1);
		t.printArray();
	}
	
}
