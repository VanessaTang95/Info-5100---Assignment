package game.blackjack;

import java.util.ArrayList;
import java.util.List;

public class GroupOfCards {
 private List<Card> cards;
 int topCard;
 GroupOfCards(){cards=new ArrayList<Card>();}

 /**
  * adds the card "card" to those presently held.
  * @param card
  */
 
  void addCard(Card card) {
	  cards.add(card);
  }
 
 /**
  * discards any cards presently held, restoring the state
  * of the cards to empty
  */
 void discardAll() {
	 cards.removeAll(cards);
 }
 
 /**
  * return the length of cards;
  * @return
  */
 int getCurrentSize() {return cards.size();};

 /**
  * display every card in cards;
  */
 void display() {
	 int size=getCurrentSize();
	 for(int i=0;i<size;i++) {
		 System.out.println(cards.get(i).getSpot()+" of "+cards.get(i).getSuit());
	 }
 }

 
 /**
  * delete the top card form the group of cards and 
  * return the deleted card value;
  * @return
  */
 
 Card deleteCard() {
	 topCard=cards.size()-1;
	 Card del_value=cards.get(topCard);
	 cards.remove(topCard);
	 return del_value;
	 }

}
