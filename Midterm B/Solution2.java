package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.directory.SearchResult;

public class Solution2 {
/**
 * Given an array of integers sorted in ascending order, 
 * find the starting and ending position of a given target value. 
 * Your algorithm's runtime complexity must be in the order of O(log n). 
 * If the target is not found in the array, return [-1, -1]. 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8,
 *  return [3, 4].     
 */
	
	
	public static void main(String[] args) {
		int[] nums= {5,7,7,8,8,10};
		int target=8;
		int[] result=searchRange(nums, target);
		System.out.println(Arrays.toString(result));
		

	}
	public static int[] searchRange(int[] nums, int target) {
		 if(nums == null || nums.length == 0){return new int[]{-1,-1};}
	        
	        int left = binarySearch(nums, 0, nums.length-1, -1, true, target);
	        int right = binarySearch(nums, 0, nums.length-1, -1, false, target);
	        
	        return new int[]{left, right};
	    }
	    
	    private static int binarySearch(int nums[], int start, int end, int last, boolean left, int target){
	        if(start > end){ return last; }
	        
	        int mid = (start + end) / 2;
	        
	        if(nums[mid] == target){ last = mid;}
	        
	        if(target < nums[mid] || (target == nums[mid] && left)){
	            return binarySearch(nums, start, mid-1, last, left, target);
	        }else{
	            return binarySearch(nums, mid+1, end, last, left, target);
	        }
	    }
    }
