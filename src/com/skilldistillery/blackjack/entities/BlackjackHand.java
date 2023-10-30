package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;

public class BlackjackHand extends Hand {
	
	
	public BlackjackHand() {
		this.cards = new ArrayList<Card>();
	}
	
	
	@Override
	public int getHandValue() {
		int summationOfCards = 0;
		for (Card individualCard : cards) {
			summationOfCards += individualCard.getRank().getValue();
//			summationOfCards = cards.get(invidualCard).getRank().getValue();
		}
//		return cards.get(1).getRank().getValue();
		return summationOfCards;
		
	}
	
	@Override
	public int getFirstHandValue() {
		int firstCardValue = cards.get(0).getRank().getValue();
		return firstCardValue;
	}

	@Override
	public String toString() {
		return "BlackjackHand [cards=" + cards + "]";
	}

	
	@Override
	public String toStringFirstCardHiddenSecond() {
		return "BlackjackHand [cards=" + cards.get(0) + ", XXXXX of XXXXX"+ "]";
	}
	
	

}
