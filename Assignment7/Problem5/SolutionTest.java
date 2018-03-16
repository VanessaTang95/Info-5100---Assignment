package problem5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {
	
	@Test
	void testMerge() throws Exception{
		int nums1[]= {1,2,5};
		int nums2[]= {4};
		int after_merge[]=Solution.merge(nums1, nums2);
		assertEquals(1,after_merge[0]);
		assertEquals(2,after_merge[1]);
		assertEquals(4,after_merge[2]);
		assertEquals(5,after_merge[3]);
		
	}

	@Test
	void testFindMedianSortedArrays() throws Exception {
		int nums1[]= {1,2,5};
		int nums2[]= {4};
		double result=Solution.findMedianSortedArrays(nums1, nums2);
		assertTrue(result==3.0);
	}

}
