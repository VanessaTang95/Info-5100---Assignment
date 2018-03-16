package problem3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RockTest {

	@Test
	void testRock() {
		Rock r1=new Rock(7);
		assertEquals("test rock constructor",7,r1.strength);
		assertEquals("test rock constructor",'r',r1.type);
	}

	@Test
	void testFight() {
		Rock r=new Rock(5);
		Scissors s=new Scissors(5);
		Paper p=new Paper(5);
	
		assertTrue("rock vs scissors",r.fight(s)==true);
		assertTrue("rock vs paper",r.fight(p)==false);
		
		assertFalse("rock loses scissors",r.fight(s)==false);
		assertFalse("rock loses paper",r.fight(p)==true);
	}

}
