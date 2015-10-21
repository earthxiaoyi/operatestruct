package com.operatestructs.hash.hash;

/**
 * 线性探测法解决hash冲突
 * @author JM
 */
public class MyHashTable {
	
	private int arraySize;
	private DataItem[] hashArray;
	
	public MyHashTable(int size){
		this.arraySize=size;
		this.hashArray = new DataItem[this.arraySize];
	}
	/**
	 * 哈希函数
	 * @param key
	 * @return
	 */
	public int hashing(int key){
		return key%this.arraySize;
	}
	
	public void insert(DataItem data){
		int item = this.hashing(data.getKey());
		//如果有碰撞,则
		while(this.hashArray[item]!=null){
			item += 1;
			item %= this.arraySize;
		}
		
		this.hashArray[item] = data;
	}
	
	public void remove(int key){
		int item = this.hashing(key);
		while(this.hashArray[item]!=null){
			//判断元素key是否等于参数key
			if(this.hashArray[item].getKey()==key){
				this.hashArray[item] = null;
				break;
			}
			
			item += 1;
			item %= this.arraySize;
		}
	}
	
	
	public DataItem find(int key){
		int item = this.hashing(key);
		while(this.hashArray[item]!=null){
			//判断元素key是否等于参数key
			if(this.hashArray[item].getKey()==key){
				return this.hashArray[item];
			}
			item += 1;
			item %= this.arraySize;
		}
		return null;
	}
	
	
	public void displayHashtable(){
		for(DataItem data:this.hashArray){
			System.out.println(data+" , ");
		}
		System.out.println();
		System.out.println("====");
	}
	
	public static void main(String[] args){
		MyHashTable hashTable = new MyHashTable(10);
		
		for(int i=0;i<10;i++){
			DataItem data = new DataItem(i, i+10);
			hashTable.insert(data);
		}
		hashTable.displayHashtable();
		hashTable.remove(5);
		hashTable.displayHashtable();
	}
}
