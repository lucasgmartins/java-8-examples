package io.redspark.java8.modifierdefault;

import org.junit.Assert;
import org.junit.Test;

public class DefaultModifierTest {

	public interface Fighter {  
		default String fight() {
			return "Fight with knife";
		}
	}
	
	public interface BasicFighter {
		default String fight(){
			return "Fight with hand";
		}
	}
	
	public class HumanFighter implements Fighter {}
	public class GlobinFighter implements Fighter {
		@Override
		public String fight() {
			return "Fight with axe";
		}
	}
	
	public class PoorFighter implements BasicFighter, Fighter {
		@Override
		public String fight() {
			return BasicFighter.super.fight();
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
	
	@Test
	public void testCreateClassWithMultipleInterfaceAndUsingSameNameOfDefaultMethod() throws Exception {
		
		PoorFighter poorFighter = new PoorFighter();
		Assert.assertEquals("Fight with hand", poorFighter.fight());
	}
}
