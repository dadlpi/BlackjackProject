package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {

	private List<Card> deck = new ArrayList<Card>() ;

	Deck() {
		Suit[] allSuits = Suit.values();
		Rank[] allRanks = Rank.values();
		for (Suit individualSuit : allSuits) {
			for (Rank individualRank : allRanks) {
				deck.add(new Card(individualSuit, individualRank) );
			}
		}

	}
	

	public int checkSize() {
		int sizeOfDeck = deck.size();
//		String message = "your size of the deck = " + sizeOfDeck;
		return sizeOfDeck;

	}
	
	public Card dealCard() {
//		return deck.get( deck.size()-1 );
		return deck.remove(deck.size()-1) ;
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
}
