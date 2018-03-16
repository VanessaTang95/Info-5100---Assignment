package problem3;


/*
*Create 3 more classes called Rock, Paper, and Scissors, which inherit
from Tool. Each of these classes will need a constructor which will take in
an int that is used to initialise the strength field. The constructor should
also initialise the type field using ‘r’ for Rock, ‘p’ for Paper, and ’s' for
Scissors.
These classes will also need a public function bool fight(Tool) that
compares their strengths in the following way: 
Rock’s strength is doubled (temporarily) when fighting scissors, but halved
(temporarily) when fighting paper. In the same way, paper has the
advantage against rock, and scissors against paper. The strength field
shouldn’t change in the function, which returns true if the original class
wins in strength and false otherwise. You may also include any extra
auxiliary functions and/or fields in any of these classes. Run the program
without changing the main function, and verify that the results are correct.

*/

public class RockPaperScissorsGame{
	 public static void main(String args[]){
	 Scissors s = new Scissors(5);
	 Paper p = new Paper(7);
	 Rock r = new Rock(15);
	 System.out.println(s.fight(p) + " , "+
	p.fight(s) );
	 System.out.println(p.fight(r) + " , "+
	r.fight(p) );
	 System.out.println(r.fight(s) + " , "+
	s.fight(r) );
	
	}
	}
 
