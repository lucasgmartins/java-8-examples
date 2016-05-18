package io.redspark.java8.collections.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class StreamFilterTest {
	
	/**
	 * Filter is very similar of clause WHERE,
	 * but return new type Optional, avoiding return null values .
	 */

	@Test
	public void testFilter() throws Exception {
		
		List<String> values = Arrays.asList("Amazon", "Azure", "DigitalOcean");
		String result = values.stream()
						.filter(value -> value.equals("Amazon"))
						.findFirst()
						.get();
		
		Assert.assertEquals("Amazon", result);
	}
	
	/**
	 * Filter by value that is not present at list with "orElse" 
	 * will bring default value
	 */
	@Test
	public void testFilterIfNotFoundValueWillBringDefaultValue() throws Exception {
		
		List<String> values = Arrays.asList("Amazon", "Azure", "DigitalOcean");
	
		String result = values.stream()
				.filter(value -> value.equals("Value not available at list "))
				.findFirst()
				.orElse("Not found");
		
		Assert.assertEquals("Not Found", result);	
	}
	
	/**
	 * Filter by value that is not present at list with "orElseThrow" 
	 * will throw a exception if not found
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilterIfNotFoundValueWillThrowException() throws Exception {
		
		List<String> values = Arrays.asList("Amazon", "Azure", "DigitalOcean");
		
		values.stream()
					.filter(value -> value.equals("Value not available at list"))
					.findFirst()
					.orElseThrow(() -> new IllegalArgumentException());
						
	}
	
	/**
	 * By default Stream API bring a Optional type, 
	 * avoiding bring null values and obvious checks, 
	 * is more ellegant check if value.isPresent then value != null.
	 */
	@Test
	public void testFilterGetOptional() throws Exception {
		
		List<String> values = Arrays.asList("Amazon", "Azure", "DigitalOcean");
		
		Optional<String> value = values.stream()
			.filter(v -> v.equals("Value not available at list"))
			.findFirst();
		
		Assert.assertFalse(value.isPresent());
		
		value = values.stream()
				.filter(v -> v.equals("Amazon"))
				.findFirst();
		
		Assert.assertTrue(value.isPresent());
	}
	
	
}
