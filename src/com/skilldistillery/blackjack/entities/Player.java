package com.skilldistillery.blackjack.entities;

public class Player {
	protected Hand hand;
	
	
	public Player(){
		this.hand = new BlackjackHand();
	}


	public void addCardToHand(Card inboundCard) {
		this.hand.cards.add(inboundCard);
	}


	public Hand getHand() {
		return hand;
	}

	public void clearHand() {
		this.hand = null;
		this.hand = new BlackjackHand();
	}


	public void setHand(Hand hand) {
		this.hand = hand;
	}
	

}
