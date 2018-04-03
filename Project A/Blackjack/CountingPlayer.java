package game.blackjack;

public class CountingPlayer extends Player {
	private int count;
	CountingPlayer(int bankroll, int minimum) {
		super(bankroll, minimum);
		count=0;
	}
	
	
	@Override
	public int bet() {
		if(count >=2 ) {
			if(2*minimum>bankroll) return bankroll;
			else return 2*minimum;
		}else return minimum;
	}


	@Override
	public void expose(Card c) {
		if(c.getSpot().ordinal()>=Spot.TWO.ordinal() && c.getSpot().ordinal()<=Spot.SIX.ordinal())
			{count++;}
		else if(c.getSpot().ordinal()>=Spot.TEN.ordinal() && c.getSpot().ordinal()<=Spot.ACE.ordinal()) {
			count--;
		}
	}

	@Override
	public void shuffled() {
		count=0;
	}
	
	@Override
	public boolean draw(Card dealer) {
		return false;
	}

	@Override
	public boolean draw(Card dealer, Hand player) {
		return false;
	}

}
