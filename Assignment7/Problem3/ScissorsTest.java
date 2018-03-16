package problem3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ScissorsTest {

	@Test
	void testScissors() {
		Scissors s1=new Scissors(5);
		assertEquals("test Constructor",5,s1.strength);
		assertEquals("test Constructor",'s',s1.type);
	}

	@Test
	void testFight() {
		Rock r=new Rock(5);
		Scissors s=new Scissors(5);
		Paper p=new Paper(5);
		
		assertTrue("scissors vs rock",s.fight(r)==false);
		assertTrue("scissors vs paper",s.fight(p)==true);
		
		assertFalse("scissors loses rock",s.fight(r)==true);
		assertFalse("scissors loses paper",s.fight(p)==false);
	}

}
