package io.redspark.java8.collections.stream;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class StreamReduceTest {

	@Test
	public void testReduce() throws Exception {

		List<Integer> values = Arrays.asList(10, 20, 30);
		int result = values.stream().reduce((value1, value2) -> value1 + value2).get();

		int expected = 60;

		// What reduce does is simplify array at one value.
		Assert.assertEquals(expected, result);
	}
}
