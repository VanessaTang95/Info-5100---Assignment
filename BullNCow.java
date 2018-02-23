scores :2 /2
/*
You are playing the following Bulls and Cows game with your friend: You
write down a number and ask your friend to guess what the number is. Each
time your friend makes a guess, you provide a hint that indicates how many
digits in said guess match your secret number exactly in both digit and
position (called "bulls") and how many digits match the secret number but
locate in the wrong position (called "cows"). Your friend will use successive
guesses and hints to eventually derive the secret number.(2 scores, if you
can solve it in one for loop, you will get an extra 2 scores).
For example:
Secret number: "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's
guess, use A to indicate the bulls and B to indicate the cows. In the above
example, your function should return "1A3B".
Please note that both secret number and friend's guess may contain
duplicate digits, for example:
Secret number: "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow,
and your function should return "1A1B".
You may assume that the secret number and your friend's guess only
contain digits, and their lengths are always equal.
Ps: please pay attention to the situation that there are digits repeated.
The lack of consideration about corner cases will lead to the loss of
scores.
You need to run test case as follow:
Secret number: "1122"
Friend's guess:"1222"
*/
package assignment;

import java.util.HashMap;
import java.util.Scanner;

public class BullNCow {

	private static void bullsNCows(String secret, String guess) {
		    int Bull=0;
		    int Cow=0;
		 //using hashmap to solve this question
		    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		 
		    //check bulls
		    for(int i=0; i<secret.length(); i++){
		        char c1 = secret.charAt(i);
		        char c2 = guess.charAt(i);
		 
		        if(c1==c2){
		            Bull++;
		        }else{
		            if(map.containsKey(c1)){
		                int j = map.get(c1);
		                j++;
		                map.put(c1, j);
		            }else{
		                map.put(c1, 1);
		            }
		        }
		    }
		 
		    //check cow
		    for(int i=0; i<secret.length(); i++){
		        char c1 = secret.charAt(i);
		        char c2 = guess.charAt(i);
		 
		        if(c1!=c2){
		            if(map.containsKey(c2)){
		                Cow++;
		                if(map.get(c2)==1){
		                    map.remove(c2);
		                }else{
		                    int j = map.get(c2);
		                    j--;
		                    map.put(c2, j);
		                }
		            }
		        } 
		    }
		 
		    System.out.println(Bull+"A"+Cow+"B"); 
		}
	
	
	public static void main(String[] args) {
		System.out.println("Please input the secret number:");
		String secret=new Scanner(System.in).nextLine();
		System.out.println("Please input the guess number:");
		String guess=new Scanner(System.in).nextLine();
		bullsNCows(secret,guess);
		
	}

	

}
