package problem;

public class Solution4 {
/**
 * Given an array of integers and a number x,
 * ﬁnd the smallest subarray 
 * with sum greater than the given value. 
 * @param args
 */
	public static void main(String[] args) {
		
		/*int arr[]= {1,4,45,6,10,19};
		int x=51;
		*/
		
		int arr[]= {1,2,4};
		int x=8;
		
		int n=arr.length;
		int ans=smallestSubWithSum(arr, n, x);
		if(ans==n+1) {
			System.out.println("Not Possible");
		}else
			System.out.println(ans);
	}
	
	public static int smallestSubWithSum(int arr[],int n,int x) {
		int small_size=n+1;
		for(int i=0;i<n;i++) {
			int cur_sum=arr[i];
			if(cur_sum>x) {
				return 1;
			}
			for(int j=i+1;j<n;j++) {
				cur_sum+=arr[j];
				
				if(cur_sum>x && (j-i+1)<small_size) {
					small_size=(j-i+1);
				}
			}
		}
		
		return small_size;
	}

}
