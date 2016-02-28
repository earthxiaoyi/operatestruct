package com.thinkinjava.generic;

import java.util.List;


public class Foods<T> {
	
	Foods<? extends Foods> foods;
	
	List<?> foodsList ;
	public Foods<? extends Foods> getFoods(){
		return foods;
	}
	
	public void setFoods(Foods<? extends Foods> t){
		this.foods = t;
	}
}
