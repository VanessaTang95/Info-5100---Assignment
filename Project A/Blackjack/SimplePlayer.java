package game.blackjack;

import game.blackjack.Hand.HandValue;

public class SimplePlayer extends Player{

	SimplePlayer(int bankroll, int minimum) {
		super(bankroll, minimum);
	}
/**
 * 
 */
	
	@Override
	public int bet() {
			return minimum;
	}

	@Override
	public boolean draw(Card dealer, Hand player) {
		HandValue playerHand=player.getHandValue();
		//hard rules
		if(!playerHand.soft) {
			if(playerHand.count<=11) return true;
			else if(playerHand.count==12) {
				if(dealer.getSpot().ordinal()>=Spot.FOUR.ordinal() && dealer.getSpot().ordinal()<=Spot.SIX.ordinal()) return false;
				else return true;
			}else if(playerHand.count>=13 && playerHand.count<=16) {//bigger than 13 but smaller than 16
				if(dealer.getSpot().ordinal()>=Spot.TWO.ordinal() && dealer.getSpot().ordinal()<Spot.SIX.ordinal()) return false;
				else return true;
			}
			else return false;//>16
		}else{//soft
			if(playerHand.count<=17) return true;
			else if(playerHand.count==18) {
				if(dealer.getSpot().ordinal()==Spot.TWO.ordinal()||
						dealer.getSpot().ordinal()==Spot.SEVEN.ordinal()
						||dealer.getSpot().ordinal()==Spot.EIGHT.ordinal()) return false;
				else return true;
			}else {//>18
				return false;
			}
		}
		
	}

	/**
	 * SIMPLE PLAYER DOES NOTHING FOR EXPOSE AND SHUFFLED EVENTS
	 */
	@Override
	public void expose(Card c) {}
	@Override
	public void shuffled() {}
	@Override
	public boolean draw(Card dealer) {
		return false;
	}

}
