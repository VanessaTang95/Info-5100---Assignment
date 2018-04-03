package game.blackjack;

import java.util.ArrayList;
import java.util.List;

class DeckEmptyException extends Exception{
	public String toString() {
		return "The deck is empty!";
	}
}

public class Deck extends GroupOfCards {
	final int DeckSize=52;
	List<Card> deck;
	int next;
	/**
	 * Constructs a "newly opened" Deck of card.
	 * First the spades from 2-A, then the hearts, clubs and diamonds.
	 * The first card dealt should be the 2 of Spades;
	 */
	Deck(){
		next=0;
		deck=new ArrayList<Card>();
		for(Suit su:Suit.values()) {
			for(Spot sp:Spot.values()) {
				deck.add(new Card(sp,su));
			}
		}
	}
	
	/**
	 * resets the deck to the state of a "newly opened" deck of card
	 */
	void reset() {
		deck.removeAll(deck);
		deck=(List<Card>) new Deck();
	}
	
	
	/**
	 * requires: n is between 0 and 52, inclusive.
	 * Cut the deck into 2 segments: the 1st n card called the "left",
	 * and the rest called the "right".
	 * Note that either right or left might be empty.
	 * Then rearrange the Deck to be the 1st card of the right, the the first card of the left
	 * the 2nd of right, the 2nd of left......
	 * once one side is exhausted, fill in the remainder of the Deck with the card remaining in the other side.
	 * finally, make the first card in this shuffled deck the next card to deal
	 * e.g.:shuffle(26) on a newly-reset() deck results in: 2-clubs, 2-spades, 3-spades....A-diamonds, A-hearts.
	 * 
	 * if shuffle is called on a deck that has already had some card dealt
	 * those card should first be restored to the deck in the order in which they were dealt,
	 * preserving the most recent post-shuffled/post-reset state.
	 */
	void shuffleOnce(int n) {//shuffle 
		//check if any cards have been dealt
		if(next>=0) next=0;
		
		if(n<=0 || n>=52) return;
		//left side
		Card left[]=new Card[DeckSize];
		for(int i=0;i<n;++i) {
			left[i]=deck.get(i);
		}
		//right side
		Card right[]=new Card[DeckSize];
		for(int j=0;j<DeckSize-n;++j) {
			right[j]=deck.get(n+j);
		}
		int index=0;
		if (n > 26) { //right side exhausted first
			for (int k = 0; k < DeckSize - n; ++k) {
				deck.set(index++, right[k]);
				deck.set(index++, left[k]);
			} 
			for (int m = DeckSize - n; m < n; ++m) {
				deck.set(index++, left[m]);
			}
		} else if (n < 26) { // left exhausted first
			for (int p = 0; p < n; ++p) {
				deck.set(index++, right[p]);
				deck.set(index++, left[p]);
			
			} for (int q = n; q < DeckSize - n; ++q) {
				deck.set(index++, right[q]);
			}
		} else { // n == 26
			for (int r = 0; r < 26; ++r) {
				deck.set(index++, right[r]);
				deck.set(index++, left[r]);
			}
		}
	}
	
	 void shuffle(int times){
		 System.out.println("Shuffling the deck");
		 for(int i=0;i<times;i++) {
			 int cut=getCut();
			 System.out.println("cut at "+cut);
			 shuffleOnce(cut);
		 }
	 }
	    // REQUIRES: times is the time of using shuffleOnce method to shuffle
	    // cards, normally time should be at least 5.

	    //EFFECTS: In each time, use Math.random to pick an cut number between
	    // 13 - 39, and then call shuffleOnce method with the number;

	 public static int getCut() {
		 int max=39;
		 int min=13;
		 double ran=Math.random();
		 return  (int)((max-min)*ran+min);
	 }
	    Card deal() throws DeckEmptyException{
	    	if(DeckSize-next==0) {
	    		reset();
	    		throw new DeckEmptyException();
	    	}
	    	return deck.get(next++);
	    };

	    // EFFECTS: returns the next Card to be dealt.  If no card
	    // remain, throws an instance of DeckEmptyExecption and then
	    // reset the deck

	    int cardsLeft(){
	        return DeckSize-next;
	    };
	    // EFFECTS: returns the number of card in the Deck that have not
	    // been dealt since the last reset/shuffle.

	
	
}
