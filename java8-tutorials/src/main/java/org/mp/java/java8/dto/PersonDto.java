package org.mp.java.java8.dto;

import org.mp.java.java8.bean.Person;

public class PersonDto {

	private int id;
	private String personName;
	private int personAge;

	public PersonDto(int id, String personName, int personAge) {
		super();
		this.id = id;
		this.personName = personName;
		this.personAge = personAge;
	}

	public int getId() {
		return id;
	}

	public String getPersonName() {
		return personName;
	}

	public int getPersonAge() {
		return personAge;
	}

	@Override
	public String toString() {
		return "PersonDto [id=" + id + ", personName=" + personName + ", personAge=" + personAge + "]";
	}

	public static PersonDto map(Person person) {
		return new PersonDto(person.getId(), String.join(" ", person.getFirstName(), person.getLastName()), person.getAge());
	}
}
