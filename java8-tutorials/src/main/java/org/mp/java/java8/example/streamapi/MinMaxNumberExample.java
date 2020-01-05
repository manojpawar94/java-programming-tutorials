package org.mp.java.java8.example.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author manojmitharampawa
 *
 */
public class MinMaxNumberExample {

	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(1, 2, 4, -8, 98, 32, 64);
		Integer minNumber1 = numberList.stream().min((number1, number2) -> number1 > number2 ? 1 : -1).get();

		System.out.println("Value of min using compare logic: " + minNumber1);
		Integer minNumber2 = numberList.stream().min(Comparator.naturalOrder()).get();

		System.out.println("Value of min using  omparator.naturalOrder(): " + minNumber2);
		Integer maxNumber = numberList.stream().max(Comparator.naturalOrder()).get();
		System.out.println("Max value: " + maxNumber);
	}
}
