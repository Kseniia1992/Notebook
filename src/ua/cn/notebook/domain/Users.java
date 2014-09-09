package ua.cn.notebook.domain;

/**
 * ����� Users �������� ���������� � �������������
 * @author Kseniia
 *
 */
public class Users {
	
	/** Id */
	private int id;
	
	/** ������� */
	private String secondName;
	
	/** ��� */
	private String firstName;
	
	/** ������� */
	private int age;
	
	/** ��� */
	private String gender;
	
	/** ������� */
	private String phone;
	
	/**
	 * @return id ����� ������������
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id ����� ������������
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return secondName ������� ������������
	 */
	public String getSecondName() {
		return secondName;
	}
	
	/**
	 * @param secondName ������� ������������
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	/**
	 * @return firstName ��� ������������
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName ��� ������������
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return age ������� ������������
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @param age ������� ������������
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * @return gender ��� ������������
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * @param gender ��� ������������
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return phone ���������� ����� ������������
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * @param phone ���������� ����� ������������
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
