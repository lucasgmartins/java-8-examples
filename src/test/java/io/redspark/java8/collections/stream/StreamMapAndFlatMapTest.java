package io.redspark.java8.collections.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class StreamMapAndFlatMapTest {

	@Test
	public void testFlatMap() throws Exception {
		
		List<List<Integer>> values = Arrays.asList(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
		
		List<Integer> actual = values.stream()
				.flatMap(v -> v.stream())
				.collect(Collectors.toList());
		
		List<Integer> expected = Arrays.asList(1, 2 , 3, 4 ,5);
		Assert.assertEquals(expected, actual);
	}
}
