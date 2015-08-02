package com.operatestructs.arrays.noorder;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除相同元素与查找相同元素
 * 
 * @author JM
 *
 */
public class OperateNoIndexRepeatable {
	private int[] datas = null;
	private int currentIndex;

	public OperateNoIndexRepeatable(int length) {
		datas = new int[length];
	}

	/**
	 * 插入元素
	 * 
	 * @param data
	 * @return
	 */
	public int insert(int data) {
		datas[currentIndex] = data;
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
		OperateNoIndexRepeatable t = new OperateNoIndexRepeatable(20);
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
