package com.operatestructs.arrays.order;

/**
 * 演示有序数组
 */
public class OperateOrderNoIndex {

    private int[] datas = null;
    private int currentIndex;

    public OperateOrderNoIndex(int length){
        datas = new int[length];
    }

    /**
     * 插入元素
     * @param data
     * @return
     */
    public int insert(int data){
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
        OperateOrderNoIndex o = new OperateOrderNoIndex(20);
        o.insert(10);
        o.insert(20);
        o.insert(3);
        o.insert(3);
        o.insert(11);
        o.insert(172);
        o.insert(143);
       o.printArray();
    }
}
