// total scores : 10 / 10
/*
:Given an array S of n integers, are there elements a, b, c in S such that a +
b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.
For example, given array S = [-1, 0, 1, 2, -1, -4]
A solution set is:
[
 [-1, 0, 1],
 [-1, -1, 2]
]
*/
package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfZero {
	
	public static List<List<Integer>> findTri(int[] nums) {//considering the results of example, using list as return datatype
	    Arrays.sort(nums);//use sort method from class Arrays to sort
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    for(int i = 0; i < nums.length-2; i++) {
	        if(i > 0 && (nums[i] == nums[i-1])) continue; // avoid duplicates
	        for(int j = i+1, k = nums.length-1; j<k;) {
	            if(nums[i] + nums[j] + nums[k] == 0) {
	                list.add(Arrays.asList(nums[i],nums[j],nums[k]));
	                j++;k--;
	                if((j < k) && (nums[j] == nums[j-1]))j++;// avoid duplicates
	                if((j < k) && (nums[k] == nums[k+1]))k--;// avoid duplicates
	            }else if(nums[i] + nums[j] + nums[k] > 0) k--;
	            else j++;
	        }
	    }
	    return list;
	}
	
	private static void printArray(int[] arr) {//print array
		System.out.print("[");
		for(int i=0;i<arr.length-1;i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println(arr[arr.length-1]+"]");
	}
	//drive the algorithm to check 
	public static void main(String[] args) {
		int[] arr= {-1, 0, 1, 2, -1, -4};
	    System.out.println("Array:");
		printArray(arr);
		System.out.println();
		System.out.println("find triplets:");
		 List<List<Integer> > triplets = findTri(arr);
		 if (!triplets.isEmpty()) {
	            System.out.println(triplets);
	        } else {
	            System.out.println("No triplets can be found");
	        }	
	}

}
