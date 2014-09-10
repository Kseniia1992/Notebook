package ua.cn.notebook.domain;

/**
 * Users class contains information about the users
 * @author Kseniia
 *
 */
public class Users {
	
	/** Id */
	private int id;
	
	/** Surname */
	private String secondName;
	
	/** Name */
	private String firstName;
	
	/** Age */
	private int age;
	
	/** Gender */
	private String gender;
	
	/** Phone */
	private String phone;
	
	/**
	 * @return id user number
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id user number
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return secondName user surname
	 */
	public String getSecondName() {
		return secondName;
	}
	
	/**
	 * @param secondName user surname
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	/**
	 * @return firstName user name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName user name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return age 
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @param age 
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * @return gender 
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * @param gender 
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return phone 
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * @param phone 
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
