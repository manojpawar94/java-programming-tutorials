package org.mp.java.java8.example.streamapi;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.mp.java.java8.bean.Person;
import org.mp.java.java8.dto.PersonDto;
import org.mp.java.java8.util.MockData;

/**
 * 
 * @author manojmitharampawa
 *
 */
public class MapExample {
	public static void main(String[] args) throws IOException {
		List<Person> people = MockData.getPeople();
		mapFunctionUsingStaticReferene(people).forEach(System.out::println);
	}

	/**
	 * 
	 * @param people
	 * @return
	 */
	public static List<PersonDto> mapFunctionUsingStaticReferene(List<Person> people) {
		return people.stream().map(PersonDto::map).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param people
	 * @return
	 */
	public static List<PersonDto> mapFunctionUsingPredictor(List<Person> people) {
		return people.stream()
				.map(person -> new PersonDto(person.getId(),
						String.join(" ", person.getFirstName(), person.getLastName()), person.getAge()))
				.collect(Collectors.toList());
	}
}
