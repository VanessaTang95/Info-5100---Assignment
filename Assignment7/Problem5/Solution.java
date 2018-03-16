package problem5;

public class Solution {
/*
There are two sorted arrays nums1 and nums2 of size m and n
respectively. Find the median of the two sorted arrays. (Score 2)
Example 1:
 nums1 = [1, 3]
 nums2 = [2]
 The median is 2.0
Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]
 The median is (2 + 3)/2 = 2.5
	
*/
	
	public static int[] merge(int[] nums1, int[] nums2) {//merge two sorted arrays into one sorted array
			int result[]=new int[nums1.length+nums2.length];
			 int i=0, j=0, k=0;//i refer to nums1;j refers to nums2;k refers to result
		        
			 /*sorting and then merging recursively*/
		        while(i<nums1.length && j<nums2.length)
		            {
		                if(nums1[i]<nums2[j])
		                    {
		                        result[k] = nums1[i]; /*copying sorted elements into a*/ 
		                        i++;
		                        k++;
		                    }
		                else
		                    {
		                        result[k] = nums2[j];
		                        j++;
		                        k++;
		                    }
		            }

		        /*copying remaining elements into result*/
		        while(i<nums1.length)
		            {
		                result[k] = nums1[i];
		                i++;
		                k++;
		            }

		        while(j<nums2.length)
		            {
		                result[k] = nums2[j];
		                j++;
		                k++;
		            }
			
			return result;
	
	}
	
	
	public static double findMedianSortedArrays(int[] nums1, int[]	nums2) {
			// add your code here
		int result[]=merge(nums1,nums2);
		int n=result.length;
		if (n%2==0) {//even number
			return (result[n/2]+result[n/2-1])/2.0;
		}else{//odd number
			return result[n/2]/1.0;
		}		
			 }

	
	public static void main(String args[]) {
		//sample
		int nums1[]= {1,2};//{1,3};
		int nums2[]= {3,4};//{2};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
