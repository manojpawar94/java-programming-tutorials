package org.mp.java.java8.util;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.mp.java.java8.bean.Car;
import org.mp.java.java8.bean.Person;

/**
 * 
 * @author manojmitharampawa
 *
 */
public class MockData {

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static ImmutableList<Person> getPeople() throws IOException {
		InputStream inputStream = Resources.getResource("people.json").openStream();
		String json = IOUtils.toString(inputStream);
		Type listType = new TypeToken<ArrayList<Person>>() {
			private static final long serialVersionUID = 1L;
		}.getType();
		List<Person> people = new Gson().fromJson(json, listType);
		return ImmutableList.copyOf(people);
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static ImmutableList<Car> getCars() throws IOException {
		InputStream inputStream = Resources.getResource("cars.json").openStream();
		String json = IOUtils.toString(inputStream);
		Type listType = new TypeToken<ArrayList<Car>>() {

			private static final long serialVersionUID = 1L;
		}.getType();
		List<Car> cars = new Gson().fromJson(json, listType);
		return ImmutableList.copyOf(cars);
	}

}
