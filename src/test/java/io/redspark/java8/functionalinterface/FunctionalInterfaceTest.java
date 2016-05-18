package io.redspark.java8.functionalinterface;

import org.junit.Assert;
import org.junit.Test;

public class FunctionalInterfaceTest {

	public class PokerPlayer {

		String play(PlayAction playAction) {
			return playAction.action();
		};

	}
	
	public interface PlayAction {
		String action();
		default String x() {
			return "xis";
		};
	}

	@Test
	public void testJava7() throws Exception {

		PokerPlayer negreanu = new PokerPlayer();
		PokerPlayer hellmuth = new PokerPlayer();

		String negreanuTurn = negreanu.play(new PlayAction() {

			@Override
			public String action() {
				return "Play a card";
			}
			
		});

		String hellmuthTurn = hellmuth.play(new PlayAction() {

			@Override
			public String action() {
				return "Bluff";
			}

		});

		Assert.assertEquals("Play a card", negreanuTurn);
		Assert.assertEquals("Bluff", hellmuthTurn);
	}

	@Test
	public void testJava8() throws Exception {

		PokerPlayer negreanu = new PokerPlayer();
		PokerPlayer hellmuth = new PokerPlayer();

		String negreanuTurn = negreanu.play(() -> {
			return "Play a card";
		});
		
		String play = hellmuth.play(() -> {
			return "Bluff";
		});

		Assert.assertEquals("Play a card", negreanuTurn);
		Assert.assertEquals("Bluff", play);
	}
}
