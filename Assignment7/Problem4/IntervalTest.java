package problem4;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class IntervalTest {

	@Test
	void testInterval() {
		Interval i1=new Interval();
		assertEquals("start",0,i1.start);
		assertEquals("end",0,i1.end);
	}

	@Test
	void testIntervalIntInt() {
		Interval i2=new Interval(1,3);
		assertEquals("start",1,i2.start);
		assertEquals("end",3,i2.end);
	}

	@Ignore
	@Test
	void testToString() {
		
	}

}
