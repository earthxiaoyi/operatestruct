package com.operatestructs.simplesort;

public class InsertSort {
	
	public static void main(String args[]){
		
		int[] as = new int[]{5,3,2,1};
		
		InsertSort in= new InsertSort();
		in.insertSort(as);
		in.printDatas(as);
		
		/*int j=2;
		System.out.println(j--);
		System.out.println(j);
		
		for(int i=10;i>5;i--){
			System.out.println(i);
		}*/
	}
	
	//插入法排序
	public void insertSort(int[] as){
		int j = 0;
		//假定第一个元素是排好序的
		//2 1 5 3 9 4
		//1 2 5 3 9 4	
		//1 2 5 3 9 4
		
		//1 2 3 5 9 4
		//1 2 3 5 9 9
		//1 2 3 
		//3 2 1 
		//2 3 1  1
				 
		for(int i=1;i<as.length;i++){
			//把元素拿出来
			int temp = as[i];
			for(j=i;j>0;j--){
				//当条件不满足时,退出循环
				if(temp<=as[j-1]){
					//赋值
					as[j] = as[j-1];
				}else{
					break;
				}
			}
			//交换
			as[j] = temp;
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
