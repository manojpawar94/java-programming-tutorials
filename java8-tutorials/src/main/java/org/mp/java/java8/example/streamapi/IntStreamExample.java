package org.mp.java.java8.example.streamapi;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import org.mp.java.java8.bean.Person;
import org.mp.java.java8.util.MockData;



/**
 * 
 * @author manojmitharampawa
 *
 */
public class IntStreamExample {

	public static void main(String[] args) throws IOException {
		System.out.println("Range Method:-");
		// range(0, 10);
		System.out.println("******************************************");
		System.out.println("RangeIteratingList Method:-");
		// rangeIteratingList();
		System.out.println("******************************************");
		System.out.println("RangeIteratingList Method:-");
		intStreamIteratorFunction();
		System.out.println("******************************************");
	}

	public static void range(int startIndex, int endIndex) {
		// range without stream api
		System.out.println("range without stream api");
		for (int index = startIndex; index <= endIndex; index++) {
			System.out.print(index + ", ");
		}

		// using the IntStream - exclusive end index
		System.out.println("\n\nusing the IntStream - exclusive end index");
		IntStream.range(startIndex, endIndex + 1).forEach(index -> System.out.print(index + ", "));

		// using the IntStream - inclusive end index
		System.out.println("\n\nusing the IntStream - inclusive end index");
		IntStream.rangeClosed(startIndex, endIndex).forEach(index -> System.out.print(index + ", "));
		System.out.println();
	}

	public static void rangeIteratingList() throws IOException {
		List<Person> people = MockData.getPeople();
		IntStream.range(0, people.size()).forEach(index -> {
			System.out.println(index + "=" + people.get(index));
		});

		// people.forEach(System.out::println);
	}

	public static void intStreamIteratorFunction() {
		IntStream.iterate(0, operator -> operator + 1).filter(index -> index % 2 == 0).limit(10)
				.forEach(System.out::println);
	}
}
