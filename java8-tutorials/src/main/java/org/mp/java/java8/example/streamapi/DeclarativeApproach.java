package org.mp.java.java8.example.streamapi;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;

import org.mp.java.java8.bean.Person;
import org.mp.java.java8.util.MockData;

/**
 * 
 * @author manojmitharampawa
 *
 */
public class DeclarativeApproach {
	public static void main(String[] args) throws IOException {
		System.out.println("personAgeFilter Method:-");
		personAgeFilter(18, 10);
	}

	public static void personAgeFilter(int ageLimit, int noOfPersons) throws IOException {
		System.out.println("******************* First 10 Young people *********************");
		ImmutableList<Person> people = MockData.getPeople();
		List<Person> youngPeople = people.stream().filter(person -> person.getAge() <= ageLimit).limit(noOfPersons)
				.collect(Collectors.toList());
		youngPeople.forEach(System.out::println);

		System.out.println("******************* First 10 adults *********************");
		MockData.getPeople().stream().filter(Person -> Person.getAge() > ageLimit).limit(noOfPersons)
				.collect(Collectors.toList()).forEach(System.out::println);
	}
}
