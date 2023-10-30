package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck deck;
	
	
	public Dealer(){
		deck = new Deck();
	}


	public Deck getDeck() {
		return deck;
	}
	


	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	public Player dealInitialTwoCards(Player player) {
		player.addCardToHand( dealCard()  );
		player.addCardToHand( dealCard()  );
		return player;
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}

	
}

