package ua.cn.notebook.domain;

/**
 * Класс Users содержит информацию о пользователях
 * @author Kseniia
 *
 */
public class Users {
	
	/** Id */
	private int id;
	
	/** Фамилия */
	private String secondName;
	
	/** Имя */
	private String firstName;
	
	/** Возраст */
	private int age;
	
	/** Пол */
	private String gender;
	
	/** Телефон */
	private String phone;
	
	/**
	 * @return id номер пользователя
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id номер пользователя
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return secondName фамилия пользоватеоя
	 */
	public String getSecondName() {
		return secondName;
	}
	
	/**
	 * @param secondName фамилия пользоватеоя
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	/**
	 * @return firstName имя пользователя
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName имя пользователя
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return age возраст пользователя
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @param age возраст пользователя
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * @return gender пол пользователя
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * @param gender пол пользователя
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return phone телефонный номер пользователя
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * @param phone телефонный номер пользователя
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
