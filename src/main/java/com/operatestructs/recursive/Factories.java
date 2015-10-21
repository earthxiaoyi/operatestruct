package com.operatestructs.recursive;

/**
 * 使用递归求阶乘
 * @author jiaming.jiang
 */
public class Factories {
	
	public static void main(String[] args){
		Factories factory = new Factories();
		int factories = factory.factories(5);
		int sum = factory.sum(100);
		System.out.println(factories);
		System.out.println(sum);
	}
	
	
	public int factories(int n){
		//退出条件.如果没有退出的条件,会造成栈溢出
		if(n==1){
			return 1;
		}
		return n*factories(n-1);
	}
	
	public int sum(int n){
		if(n==0){
			return n;
		}
		return n+sum(n-1);
	}
}
