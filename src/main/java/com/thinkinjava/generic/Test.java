package com.thinkinjava.generic;

public class Test {
	public static void main(String[] args) {
		Foods<Beef> foods = new Foods<Beef>();
		
		foods.setFoods(new Beef());
		
		Foods<? extends Foods> foods2 = foods.getFoods();
		System.out.println(foods2);
	}
}
