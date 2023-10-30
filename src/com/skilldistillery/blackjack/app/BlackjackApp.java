package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {
	Dealer guidoDealer = new Dealer();
	Player joBlo = new Player();

	public static void main(String[] args) {

		BlackjackApp app = new BlackjackApp();
		System.out.println(" #####      WELCOME TO THE BLACKJACK GAMBLING APPLICATION      #####");
		System.out.println("   ## Here is yout inital hand - Keep playing until you type quit ##");
		app.run();
	}

	public void run() {
		initalRoundDeal();
//		guidoDealer.getDeck().shuffleDeck();
//		 System.out.println( guidoDealer.getHand().getHandValue());
		 Scanner keyboardInput = new Scanner(System.in);
		 while (true) {
//			 displayCurrentHandsOfAllPrePlayerStand();
			 playerTestOfRound();
			 hitStandQuestion();
//			 keyboardInput.nextLine(); //this clears the scanner cache after not using the line
			 String Selection = keyboardInput.next(); // GO BACK AND CHECK TO UPPERCASE METHOD
			 keyboardInput.nextLine(); //this clears the scanner cache after not using the line
			 if(Selection.equals("Hit") || Selection.equals("hit") ||Selection.equals("HIT") ) {
//				 System.out.println("you've selected to hit");
				 hitMethod(joBlo);
			 displayCurrentHandsOfAllPrePlayerStand();
//				 System.out.println( "Player hand: " + joBlo.getHand().toString());
//				 System.out.println( joBlo.getHand().getHandValue() );
//				 hitMethod();  --this will add a card to the player
			 }else if (Selection.equals("Stand") || Selection.equals("stand") ||Selection.equals("STAND") ){
				 System.out.println("you've selected to stand, Dealer's Turn");
				 DealerTestOfRound(); //this takes care of initial blackjack on dealer
//				 DealerTestOfRound(); //this takes care of initial blackjack on dealer
				 displayCurrentHandsOfAll();
				 while (true) {
					 if ( guidoDealer.getHand().getHandValue() < 17){
						 System.out.println("dealer can hit, below 17");
						 hitMethod(guidoDealer);
						 displayCurrentHandsOfAll();
					 } else if (guidoDealer.getHand().getHandValue() >= 17) {
						 System.out.println("Dealer can not hit, rule of 17");
//						 displayCurrentHandsOfAll();
						 DealerTestOfRound(); //this takes care of initial blackjack on dealer
						 dealerToPlayerWinnerTest();
						 //you are going to have to evaluate a winner here
						 //then reset the hand
						 break;
					 }
				 }
				 DealerTestOfRound();
//				 dealerConditionalHitMethod(); //do the logic here for below 17 dealer must hit 
			 }else if (Selection.equals("Quit") || Selection.equals("quit") ||Selection.equals("QUIT") ){
				 System.out.println("you've selected to quit, THANK YOU FOR USING OUR BLACKJACK GAME");
				 break;
			 }else {
				 System.err.println("you've selected an invalid selection, try again");
			 }
			 
			 playerTestOfRound();
			 //testOfRound(); //this will test if there is Blackjack (Win) or Bust (Loss)
		 }
		
	}
	
	public void hitStandQuestion() {
		System.out.println("Do you PLAYER want to \"hit\" or \"stand\" ?");
		System.out.println("Type hit or stand or quit");
	}

	public void playerTestOfRound() {
		if ( joBlo.getHand().getHandValue() == 21) {
			System.out.println("You've gotten a Blackjack 21 WIN!!!!!!! YOU WIN!!!");
			roundTerminationProcedure();
//			System.out.println("#######################################");
			
		} else if (joBlo.getHand().getHandValue() >= 21) {
			System.out.println("YOU HAVE BUSTED!!!!!!!! DEALER WINS");
			roundTerminationProcedure();
//			System.out.println("#######################");
//			initalRoundDeal();
		} 
		System.out.println(  );
		
	}
	
	public Player hitMethod(Player player) {
		player.addCardToHand( guidoDealer.dealCard() );
		return player;
		
	}
	
	
	public void displayCurrentHandsOfAllPrePlayerStand() {
		System.out.println( "Dealer hand: " + guidoDealer.getHand().toStringFirstCardHiddenSecond());
		 System.out.println( guidoDealer.getHand().getFirstHandValue() );
		 System.out.println( "Player hand: " + joBlo.getHand().toString());
		 System.out.println( joBlo.getHand().getHandValue());
		 System.out.println();
	}

	public void displayCurrentHandsOfAll() {
		System.out.println( "Dealer hand: " + guidoDealer.getHand().toString());
		System.out.println( guidoDealer.getHand().getHandValue() ) ;
		System.out.println( "Player hand: " + joBlo.getHand().toString());
		System.out.println( joBlo.getHand().getHandValue());
		System.out.println();
	}
	
	public void initalRoundDeal() {
		guidoDealer.getDeck().shuffleDeck();
		guidoDealer.dealInitialTwoCards(guidoDealer);
		joBlo = guidoDealer.dealInitialTwoCards( joBlo);
		displayCurrentHandsOfAllPrePlayerStand();
	}
	
	public void clearHand(Player indivualPLayer) {
		indivualPLayer.clearHand();
	}

	public void roundTerminationProcedure() {
		System.out.println("############ ROUND RESULTS ###########");
		displayCurrentHandsOfAll();
		clearHand(joBlo);
		clearHand(guidoDealer);
		System.out.println("*********** FINAL ROUND RESULTS ABOVE ********");
		System.out.println();
		System.out.println("######### STARTING NEW ROUND ##########");
		initalRoundDeal();
	}
	
	public void DealerTestOfRound() {
		if ( guidoDealer.getHand().getHandValue() == 21) {
			System.out.println("Dealer has Blackjack 21!!!!!!! DEALER WINS!!!");
			roundTerminationProcedure();
			
		} else if (guidoDealer.getHand().getHandValue() >= 21) {
			System.out.println("DEALER HAS BUSTED!!!!!!!! YOU WIN");
			roundTerminationProcedure();
		} 
		System.out.println(  );
		
	}
	
	public void dealerToPlayerWinnerTest() {
		if ( guidoDealer.getHand().getHandValue() == joBlo.getHand().getHandValue() ) {
			System.out.println("PUSH -- STANDOFF -- TIE Scenario");
			roundTerminationProcedure();
			
		} else if ( guidoDealer.getHand().getHandValue() > joBlo.getHand().getHandValue() ) {
			System.out.println("DEALER IS HOLDING A GREATER COUNT OF CARDS, DEALER WINS");
			roundTerminationProcedure();
		} else if ( guidoDealer.getHand().getHandValue() > joBlo.getHand().getHandValue() ) {
			System.out.println("YOU THE PLAYER ARE HOLDING A GREATER COUNT OF CARDS, YOU WIN");
			roundTerminationProcedure();
		}
		System.out.println(  );
		
	}
}