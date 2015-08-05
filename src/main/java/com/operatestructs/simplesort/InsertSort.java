package com.operatestructs.simplesort;

public class InsertSort {
	
	public static void main(String args[]){
		
		int[] as = new int[]{1,2,2,2,1,44,55,33,122,4,5};
		
		InsertSort in= new InsertSort();
		in.insertSort(as);
		in.printDatas(as);
	}
	
	//插入法排序
	public void insertSort(int[] as){
		int j = 0;
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
