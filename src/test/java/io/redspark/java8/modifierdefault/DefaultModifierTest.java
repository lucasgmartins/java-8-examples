package io.redspark.java8.modifierdefault;

import org.junit.Assert;
import org.junit.Test;

public class DefaultModifierTest {

	public static interface Fighter {  
		default String fight() {
			return "Fight with knife";
		}
	}
	
	public static class HumanFighter implements Fighter {}
	public static class GlobinFighter implements Fighter {
		@Override
		public String fight() {
			return "Fight with axe";
		}
	}
	
	/**
	 * default access enable implement methods without obligatoriness and must have a default behavior.
	 */
	@Test
	public void testDefaultMethodWithBehavior() throws Exception {
		 
		HumanFighter humanFighter = new HumanFighter(); 
		Assert.assertEquals("Fight with knife", humanFighter.fight());
		
		GlobinFighter globinFighter = new GlobinFighter();
		Assert.assertEquals("Fight with axe", globinFighter.fight());
	}
}
