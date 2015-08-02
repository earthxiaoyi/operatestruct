package com.operatestructs.arrays.object;

/**
 * 用户
 * @author jiaming.jiang
 *
 */
public class UserModel {
	private int userId;
	private String userName;
	private int age;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public UserModel() {
		super();
	}
	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userName=" + userName
				+ ", age=" + age + "]";
	}
	public UserModel(int userId, String userName, int age) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.age = age;
	}
}
