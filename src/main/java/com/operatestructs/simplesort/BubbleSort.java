package com.operatestructs.simplesort;

/**
 * 冒泡排序算法演示
 */
public class BubbleSort {
	
	
	public static void main(String args[]){
		int[] as = new int[]{1,2,2,2,1,44,55,33,122,4,5};
		BubbleSort b = new BubbleSort();
		//冒泡排序
		b.bubbleSort(as);
		
		b.bubbleSort2(as);
	}
	
	private void bubbleSort(int[] as) {
		//
		System.out.println("=======冒泡排序");
		
		for(int i=as.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(as[j]>as[j+1]){
					swap(as,i,j);
				}
			}
		}
		
		printDatas(as);
	}

	/**
	 * 冒泡排序2
	 * @param as 传递的数组
	 */
	public void bubbleSort2(int[] as){
		System.out.println("=========冒泡排序");
		for(int i=0;i<as.length-1;i++){
			for(int j=i+1;j<as.length;j++){
				if(as[i]>as[j]){
					swap(as,i,j);
				}
			}
		}
		printDatas(as);
	}
	
	private void printDatas(int[] as){
		//print array
		for(int i=0;i<as.length;i++){
			System.out.println(as[i]+",");
		}
	}
	
	//交换数据
	private void swap(int[] as,int aIndex,int bIndex){
		int temp = as[aIndex];
		as[aIndex] = as[bIndex];
		as[bIndex] = temp;
	}
	
}
