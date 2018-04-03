package problem;

import java.util.Arrays;

public class Solution3 {
/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * @param args
 */
	public static void main(String[] args) {
			int arr[]= {1,2,3,4,5,6,7};
			int d=2;
			System.out.println("Original Array:"+Arrays.toString(arr));
			rotatedArray(arr, d, arr.length);
			System.out.println("Now array is:"+Arrays.toString(arr));
	}
	
	public static void rotatedArray(int nums[],int d, int n) {
		for(int i=0;i<d;i++) {
			int temp=nums[0];
			int j;
			for(j=0;j<n-1;j++) {
				nums[j]=nums[j+1];
			}
			nums[j]=temp;
		}
	}

}
