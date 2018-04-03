package game.blackjack;

public class Hand extends GroupOfCards {
		public class HandValue{
		int count;	//value of hand
		boolean soft; //true if hand value is a soft count;
		HandValue(int count,boolean soft){
		this.count=count;
		this.soft=soft;
	}
		}
	
	//Overview: A blackjack hand of zero or more cards
	
	private HandValue curValue=new HandValue(0,false);
	/**
	 * establishes an empty blackjack hand
	 */
	
	/**
	 * returns the present value of the blackjack hand.
	 * The count field is the highest blackjack total possible 
	 * without going over 21.
	 * The soft field should be true iff at least 1 Ace is present,
	 * and its value is counted as 11 rather than 1.
	 * If the hand is over 21, any value over 21 may be returned;
	 * 
	 * Note: you are not allowed to change any member variables 
	 * inside handValue. It is required because Players only get 
	 * const Hands passed to them, and therefore can only call methods
	 * like addCard, to change the hand. 
	 * @return
	 */
	void addCard(Card c) {
		//hard case 
			if(c.getSpot().ordinal()<Spot.TEN.ordinal()) {
				if(curValue.soft && curValue.count+c.getSpot().getValue()+2>21) {
					curValue.count-=10;
					curValue.soft=false;
				}
				curValue.count+=c.getSpot().getValue();
				return;
			}
			//hard case & 10
			else if(c.getSpot().ordinal()>=Spot.TEN.ordinal() && c.getSpot().ordinal()<=Spot.KING.ordinal()) {
				if(curValue.soft && curValue.count+10>21) {
					curValue.count-=10;
					curValue.soft=false;
				}
				curValue.count+=10;
				return;		
		}
			//ace case
			else {
				//use as 1
				if(curValue.count>10) {
					curValue.count++;
					return;
				}else {
					//use as 11
					curValue.count+=11;
					curValue.soft=true;
					return;
				}
			}
	}
	
	HandValue getHandValue() {
		return curValue;
	}
	
	HandValue resetValue() {
		curValue.count=0;
		curValue.soft=false;
		return curValue;
	}
}
