package com.skilldistillery.blackjack.entities;

import java.util.List;

public abstract class Hand {

	protected List<Card> cards;
	
	public abstract int getHandValue();

	public int getFirstHandValue() {
		return 0;
	}

	public String toStringFirstCardHiddenSecond() {
		return null;
	}

	
	
	
}
