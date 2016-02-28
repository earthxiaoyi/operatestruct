package com.operatestructs.recursive;
/**
 * 使用递归来实现归并排序
 * @author jiaming.jiang
 *
 */
public class MergeSort {
	
	/**
	 * 使用递归进行归并排序
	 * @param theArray	需要排序的数组
	 */
	public void mergeSort(int[] theArray){
		int[] temp = new int[theArray.length];
		this.doMergeSort(theArray, temp, 0, theArray.length-1);
	}
	
	/**
	 * 执行归并排序的数组
	 * @param theArray	需要排序的数组
	 * @param temp		临时的归并用的数组
	 * @param lowerBound	左边的索引边界
	 * @param highBound		右边的索引边界
	 */
	public void doMergeSort(int[] theArray,int[] temp,int lowerBound,int highBound){
		if(lowerBound>=highBound){
			return;
		}
		int mid = (lowerBound+highBound)/2; //计算分界的索引
		this.doMergeSort(theArray, temp, lowerBound, mid);//对左边进行排序
		this.doMergeSort(theArray, temp, mid+1, highBound);//对右边进行排序
		this.merge(theArray, temp, lowerBound, mid+1, highBound);	//合并排序结果
	}
	
	public void merge(int[] theArray,int[] temp,int lowerIndex,int highIndex,int highBound){
		//合并到temp的索引记录
		int count=0;
		//记录左边的最小索引边界
		int lowerBound = lowerIndex;
		//记录左边最大索引边界
		int mid = highIndex-1;
		
		//1.从左边依次取值跟右边的比较
		while(lowerIndex<=mid && highIndex<=highBound){
			//1.1如果左边的值比右边的小，那就把左边的值加入temp
			if(theArray[lowerIndex]<theArray[highIndex]){
				temp[count++] = theArray[lowerIndex++];
			}else{
				//1.2如果左边的值比右边的大，把右边的这个值加入temp，继续比较
				temp[count++] = theArray[highIndex++];
			}
		}
		
		//分别处理两边剩余的数据
		//2.1：处理左边留下的数据
		while(lowerIndex<=mid){
			temp[count++] = theArray[lowerIndex++];
		}
		//2.2：处理右边留下的数据
		while(highIndex<=highBound){
			temp[count++] = theArray[highIndex++];
		}
		
		//复制数据
		for(int i=0;i<(highBound-lowerBound+1);i++){
			theArray[lowerBound+i] = temp[i];
		}
	}
	
	public static void main(String[] args) {
		int[] theArray = new int[]{3,1,666,2,45,5657,6756,34,345,3,45};
		MergeSort merge = new MergeSort();
		merge.mergeSort(theArray);
		
		for(int as:theArray){
			System.out.println(as);
		}
	}
}
