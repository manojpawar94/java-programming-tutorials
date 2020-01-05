package org.mp.java.java8.bean;

/**
 * 
 * @author manojmitharampawa
 *
 */
public class Person {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private Integer age;

	public Person(Integer id, String firstName, String lastName, String email, String gender, Integer age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", age=" + age + "]";
	}

}
