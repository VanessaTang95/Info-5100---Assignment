package problem4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a set of time intervals in any order, merge all overlapping
intervals into one and output the result which should have only mutually
exclusive intervals. Let the intervals be represented as pairs of integers
for simplicity.
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }.
The intervals {1,3} and {2,4} overlap with each other, so they should be
merged and become {1, 4}. Similarly {5, 7} and {6, 8} should be merged
and become {5, 8}
*/

public class Solution {
	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals.size()<=0) return intervals;
		
		List<Interval> result=new ArrayList<Interval>();
		int l=intervals.size();
		int[] start=new int[l];
		int end[]=new int[l];
		//declare and initialize two array to store the start and end of intervals
		for(int i=0;i<l;i++) {
			start[i]=intervals.get(i).start;
			end[i]=intervals.get(i).end;
		}
		//sort arrays
		Arrays.sort(start);
		Arrays.sort(end);
		
		//detect overlap and merge lap
		for(int i=0,j=0;i<l;i++) {
			if(i==l-1||start[i+1]>end[i]) {
				result.add(new Interval(start[j],end[i]));
				j=i+1;
			}
		}
		
		return result;
		}

	public static void main(String[] args) {
		List<Interval> i=new ArrayList<Interval>();
		i.add(new Interval(1,3));
		i.add(new Interval(2,6));
		i.add(new Interval(8,10));
		i.add(new Interval(15,18));
		System.out.println("Original:"+i);
		System.out.println("After merging:"+merge(i));
		
	}
}
