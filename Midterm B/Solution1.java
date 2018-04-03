package problem;

public class Solution1 {

	/**
	 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray)
	 * Example 1:
	 * Input: [1,3,5,4,7] Output: 3 
	 * Explanation: The longest continuous increasing subsequence is [1,3,5], 
	 * its length is 3.  Even though [1,3,5,7] is also an increasing subsequence, 
	 * it's not a continuous one where 5 and 7 are separated by 4.
	 * @param args
	 */
		public static void main(String[] args) {
			int arr[]= {2,2,2,2,2,2};
			print(arr);
			System.out.println("The length of longest continuous subsequence is:"+lengthOfLongestSubsequence(arr));

		}
		public static void print(int arr[]) {
			System.out.print("[");
			for(int i=0;i<arr.length-1;i++) {
				System.out.print(arr[i]+",");
			}
			System.out.print(arr[arr.length-1]+"]");
		}
		
		public static int lengthOfLongestSubsequence(int nums[]) {
		  	int n=nums.length;
					int max=0;
					int count=0;
					for(int i=0;i<n;i++) {
						if(i==0 || nums[i-1]<nums[i]) {
							max=Math.max(++count, max);
						}else {
							count=1;
						}
					}
					return max;
		}

}
