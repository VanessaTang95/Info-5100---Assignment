package game.blackjack;

import java.util.Scanner;
import game.blackjack.Deck;

public class BlackJack {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Deck deck=new Deck();
		
		System.out.println("---Welcome to the game---");
		System.out.println("Please set:");
		System.out.println("Bankroll||Tricks||Min_Wage||Player_Type(Simple|Counting)");
		int bankroll=s.nextInt();
		int tricktimes=s.nextInt();
		int min_wage=s.nextInt();
		String player_type=s.next();
		int trick=tricktimes;
		Dealer dealer=new Dealer();
		Player player = null;
		deck.shuffle(7);
		
		if(player_type.equals("simple")) {
			player=new SimplePlayer(bankroll,min_wage);
		}else if(player_type.equals("counting")) {
			player=new CountingPlayer(bankroll,min_wage);
		}
	
		//start game
		while(tricktimes>0 && player.bankroll>=min_wage) {
			
			Trick tr=new Trick(player, dealer, deck);
			System.out.println();
			System.out.println("Trick "+ (trick-tricktimes+1)+" bankroll "+player.bankroll);
			if(deck.cardsLeft()<20) {
				deck.shuffle(7);
				player.shuffled();
			}
			try {
				tr.play();
			} catch (DeckEmptyException e) {
				deck.shuffle(7);
				player.shuffled();
				continue;
			}finally {
				tricktimes--;
			}
		}
		System.out.println();
		if(tricktimes==0) {
			System.out.println("Player has "+player.bankroll+" after "+trick+" tricks");
		}
	}

}
