package com.operatestructs.arrays.noorder;

/**
 * 无索引的数组
 * Created by JM on 2015-8-2.
 */
public class OperateNoIndex {

    private int[] datas = null;
    private int currentIndex;

    public OperateNoIndex(int length){
        datas = new int[length];
    }

    /**
     * 插入元素
     * @param data
     * @return
     */
    public int insert(int data){
        datas[currentIndex] = data;
        currentIndex++;
        return currentIndex-1;
    }

    /**
     * 删除元素
     * @param data
     */
    public void remove(int data){
        //查找元素索引位置
        int index =  this.getIndex(data);
        //删除元素，再排序
        for(int i = index;i<currentIndex;i++){
            datas[i] = datas[i+1];
        }
        currentIndex--;
    }

    public int searchOne(int data){
        int index = this.getIndex(data);
        if(index >= 0){
            return datas[index];
        }
        return 0;
    }

    /**
     * 根据数据，从数组中查找索引
     * @param data
     * @return
     */
    private int getIndex(int data){
        int index = -1;
        for(int i=0;i<datas.length;i++){
            if(datas[i]==data){
                index = i;
                break;
            }
        }
        return index;
    }

	public void printArray(){
		for(int i=0;i<datas.length;i++){
			System.out.print(datas[i]+",");
		}
		System.out.println("");
	}
    
    public static void main(String args[]) {
        OperateNoIndex o = new OperateNoIndex(20);
        o.insert(10);
        o.insert(20);
       o.remove(10);
       o.printArray();
    }
}
