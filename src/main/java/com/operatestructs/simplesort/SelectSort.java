package com.operatestructs.simplesort;

public class SelectSort {
	
	public static void main(String[] args) {
		int[] as = new int[]{1,2,2,2,1,44,55,33,122,4,5};
		SelectSort selectSort = new SelectSort();
		selectSort.selectSort(as);
		selectSort.printDatas(as);
		System.out.println(as.length+" as length");
	}
	
	public void selectSort(int[] as){
		int min = 0;
		for(int i=0;i<as.length-1;i++){
			min = i;
			for(int j=i+1;j<as.length;j++){
				if(as[min]>as[j]){
					min = j;
				}
			}
			swap(as,min,i);
		}
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
