package game.blackjack;

public class Dealer {
	Hand hand;
	Dealer(){
		hand=new Hand();
	}
	
	/**
	 * the dealer must hit until he either reaches a total greater
	 * than equal to 17(hard or soft), or busts
	 * @return
	 */
	
	public boolean draw() {
		return hand.getHandValue().count<17;
	}
}
