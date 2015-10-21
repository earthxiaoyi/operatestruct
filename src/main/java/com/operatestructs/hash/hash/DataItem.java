package com.operatestructs.hash.hash;

public class DataItem {
	private int id;
	private int bussinnessData;
	public DataItem(int id, int bussinnessData) {
		this.id = id;
		this.bussinnessData = bussinnessData;
	}
	
	public int getKey(){
		return this.id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBussinnessData() {
		return bussinnessData;
	}
	public void setBussinnessData(int bussinnessData) {
		this.bussinnessData = bussinnessData;
	}

	@Override
	public String toString() {
		return "DataItem [id=" + id + ", bussinnessData=" + bussinnessData
				+ "]";
	}
}
