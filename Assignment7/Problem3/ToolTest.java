package problem3;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ToolTest {
	@Test
	void testTool() {
		Tool t1=new Tool();
		assertEquals("Testing constructor without parameter",0,t1.strength);
		
	}

	@Test
	void testToolInt() {
		Tool t2=new Tool(5);
		assertEquals("Testing constructor with one interger input",5,t2.strength);
		
	}

	@Test
	void testSetStrength() {
		Tool t3=new Tool();
		t3.setStrength(7);
		assertEquals("Testing setStrength method",7,t3.strength);
		
	}

}
