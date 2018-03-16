package problem3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PaperTest {

	@Test
	void testPaper() {
		Paper p=new Paper(10);
		assertEquals("constructor:strength",10, p.strength);
		assertEquals("constructor:type",'p', p.type);		
	}

	@Test
	void testFight() {
		Rock r=new Rock(5);
		Scissors s=new Scissors(5);
		Paper p=new Paper(5);
	
		assertTrue("paper vs scissors",p.fight(s)==false);
		assertTrue("rock vs paper",p.fight(r)==true);
		
		assertFalse("paper loses scissors",p.fight(s)==true);
		assertFalse("paper loses rock",p.fight(r)==false);

	}

}
