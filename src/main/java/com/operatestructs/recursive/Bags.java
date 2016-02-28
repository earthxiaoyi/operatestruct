package com.operatestructs.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归解决背包问题。
 * @author jiaming.jiang
 *
 */
public class Bags {
	
	
	/**
	 * 用递归解决背包的问题
	 * @param as	物品重量数组
	 * @param targetWeight	背包的目标重量
	 * @param nowIndex	当前已取出的索引
	 * @param results	记录结果
	 */
	public void bag(int[] as,int targetWeight,int nowIndex,List<Integer> results){
		
		//递归退出条件
		if(nowIndex == as.length){
			return;
		}
		
		if(as[nowIndex]>targetWeight){
			this.bag(as, targetWeight, ++nowIndex, results);
		}else if(as[nowIndex] == targetWeight){
			results.add(targetWeight);
			System.out.println("one results:"+results);
			results.clear();
		}else{
			results.add(as[nowIndex]);
			this.bag(as, targetWeight-as[nowIndex], ++nowIndex, results);
		}
	}
	
	public static void main(String[] args) {
		Bags bags = new Bags();
		int[] as = new int[]{11,8,7,5};
		int targetWeight = 19;
		List<Integer> results = new ArrayList<Integer>();
		for(int i=0;i<as.length;i++){
			bags.bag(as, targetWeight, i, results);
		}
	}
}
