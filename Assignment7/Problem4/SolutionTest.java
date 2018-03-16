package problem4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SolutionTest {

	@Test
	void testMerge() throws Exception{
	List<Interval> i=new ArrayList<Interval>();	
	i.add(new Interval(1,3));
	i.add(new Interval(2,4));
	i.add(new Interval(7,8));
	i.add(new Interval(6,9));
	
	int start1=Solution.merge(i).get(0).start;
	int end1=Solution.merge(i).get(0).end;
	int start2=Solution.merge(i).get(1).start;
	int end2=Solution.merge(i).get(1).end;
	
	assertTrue(start1==1);
	assertTrue(end1==4);
	assertTrue(start2==6);
	assertTrue(end2==9);
	
	}

}
