package game.blackjack;

public class Trick {
		Player player=null;
	    Dealer dealer=new Dealer();
	    Deck deck;
	    Card curCard;
	    Card dealerCard;
	    Card secretCard;
	    int wager;
	    int minimum;
	   int bankroll;
	    
	   Trick(Player player,Dealer dealer,Deck deck){
		   this.player=player;
		   this.dealer=dealer;
		   this.deck=deck;
	   }
	   
	    void play() throws DeckEmptyException{
	    	wager();
	    	DealFour();
	    	playerTurn();
	    	dealerTurn();
	    	closeTurn();
	    }
	    // execute the five following steps;

	    void wager(){
	    	wager=player.bet();
	    	System.out.println("Player bets "+wager);
	    };

	    void DealFour() throws DeckEmptyException{
	    	player.hand.discardAll();
	    	dealer.hand.discardAll();
	    	
	    	//first card
	    	curCard=deck.deal();
	    	System.out.println("Player dealt "+curCard.getSpot()+" of "+curCard.getSuit());
	    	player.hand.addCard(curCard);
	    	player.expose(curCard);
	    	
	    	//second card
	    	dealerCard=deck.deal();
	    	System.out.println("Dealer dealy "+dealerCard.getSpot()+" of "+dealerCard.getSuit());
	    	dealer.hand.addCard(dealerCard);
	    	player.expose(dealerCard);
	    	
	    	//third card
	    	curCard=deck.deal();
	    	System.out.println("Player dealt "+curCard.getSpot()+" of "+curCard.getSuit());
	    	player.hand.addCard(curCard);
	    	player.expose(curCard);
	    	
	    	//fourth card,hidden
	    	secretCard=deck.deal();
	    	System.out.println("Dealer dealt a hole card.");
	    	dealer.hand.addCard(secretCard);
	    	
	    };
	    //After the wager, the dealer deals a total of four cards:
	    // the first face-up to the player, the second face-up to
	    // himself, the third face-up to the player, and the fourth
	    // face-down to himself.

	    void playerTurn() throws DeckEmptyException{
	    	
	    	while(player.draw(dealerCard, player.hand)) {
	    		curCard=deck.deal();
	    		System.out.println("Player dealt "+curCard.getSpot()+" of "+curCard.getSuit());
	    		player.hand.addCard(curCard);
	    		player.expose(curCard);
	    	}
	    	int count=player.hand.getHandValue().count;
	    	System.out.println("Player's total is "+count);
	    	if(count==21 && player.hand.getCurrentSize()==2) {
	    		System.out.println("Player dealt natural 21");
	    	}
	    	if(count>21) {
	    		System.out.println("Player busts");
	    	}
	    	}

	    void dealerTurn() throws DeckEmptyException{
	    	if(player.hand.getHandValue().count==21 && player.hand.getCurrentSize()==2) {//player deals natural 21
	    		return;  
	    	}else if(player.hand.getHandValue().count>21){//player bust
	    		return;
	    	}else{
	    		System.out.println("Dealer's hole card is "+secretCard.getSpot()+" of "+secretCard.getSuit());
	    		player.expose(secretCard);

	    	while(dealer.hand.getHandValue().count<17) {
	    		curCard=deck.deal();
	    		System.out.println("Dealer dealt "+ curCard.getSpot()+" of "+curCard.getSuit());
	    		dealer.hand.addCard(curCard);
	    		player.expose(curCard);
	    	}
	    	System.out.println("Dealer's total is "+dealer.hand.getHandValue().count);
	    	if(dealer.hand.getHandValue().count>21) {
	    		System.out.println("Dealer busts");
	    	}
	    	}
	    };

	    // dealer's turn only happens if the player hasn’t busted or the player is
	    // not dealt a natural 21 .

	    void closeTurn(){
	    	//check player state
	    	//check if natural 21
	    	if(player.hand.getHandValue().count==21 && player.hand.getCurrentSize()==2) {
	    		player.bankroll+=(3*wager)/2;
	    		player.hand.resetValue();
	    		dealer.hand.resetValue();
	    		player.hand.discardAll();
	    		dealer.hand.discardAll();
	    		return;  
	    	}
	    	//check if bust
	    	if(player.hand.getHandValue().count>21) {
	    		player.bankroll-=wager;
	    		player.hand.resetValue();
	    		dealer.hand.resetValue();
	    		dealer.hand.discardAll();
	    		dealer.hand.discardAll();
	    		return;
	    	}	    	
	    	//check dealer state
	    	//if bust?
	    	if(dealer.hand.getHandValue().count>21) {
	    		player.bankroll+=wager;
	    		player.hand.resetValue();
	    		dealer.hand.resetValue();
	    		dealer.hand.discardAll();
	    		dealer.hand.discardAll();
	    		return;
	    	}
	    	//if dealer win?
	    	if(dealer.hand.getHandValue().count>player.hand.getHandValue().count) {
	    		System.out.println("Dealer wins");
	    		player.bankroll-=wager;
	    		player.hand.resetValue();
	    		dealer.hand.resetValue();
	    		player.hand.discardAll();
	    		dealer.hand.discardAll();
	    		return;
	    	}else if(dealer.hand.getHandValue().count<player.hand.getHandValue().count){
	    		System.out.println("Player wins");
	    		player.bankroll+=wager;
	    		player.hand.resetValue();
	    		dealer.hand.resetValue();
	    		player.hand.discardAll();
	    		dealer.hand.discardAll();
	    		return;
	    	}
	    
	    };
	    // compare the count and give back reward to player if win.

}
