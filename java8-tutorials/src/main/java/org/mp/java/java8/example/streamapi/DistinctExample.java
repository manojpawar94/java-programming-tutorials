package org.mp.java.java8.example.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctExample {
	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(0, 1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9, 9, 9, 9);
		distinctNumber(numberList);
		distinctNumberWIthoutDistinctFunction(numberList);
	}

	/**
	 * 
	 * @param list
	 */
	public static void distinctNumber(List<Integer> list) {
		list.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
	}

	/**
	 * 
	 * @param list
	 */
	public static void distinctNumberWIthoutDistinctFunction(List<Integer> list) {
		list.stream().collect(Collectors.toSet()).forEach(System.out::println);
	}
}
