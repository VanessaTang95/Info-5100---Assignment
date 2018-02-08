／／good job 




package assignment;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Findindices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int arr[]= {1,3,5,7,6,9};
		int arr[]= {2,7,11,15};
		int target=9;
		System.out.println("Target Number is:"+target+",Array is:");
		printArray(arr);
		int arr2[]=indices(arr,target); //find indices method 1
		//int arr2[]=indices2(arr,target);//find indices method 2
		if (arr2[1]!=arr2[0]){// make sure that the indices are exists
			System.out.println("The indices are:");
			printArray(arr2);
		}else {
			System.out.println("Not find!");
		}
		
	}

	private static int[] indices2(int[] arr, int target) {//method 2 using hashmap
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> h=new HashMap();
		int temp[]=new int[2];//using temp to store indices
		for(int i=0;i<arr.length;i++) {
			//start with arr[0],if value of target-arr[0] contains in the hashmap,
			//store keys/indices into temp
			//if not, put arr[i] into HashMap, key=i;value=arr[i]
			if(/*h.get(target - arr[i]) != null*/h.containsKey(target-arr[i])){
				temp[0]=h.get(target-arr[i]);
				temp[1]=i;
				break;
			}else {
				h.put(arr[i],i);
			}
		}
		return temp;
	}

	private static int[] indices(int[] arr, int target) {//method1
		// TODO Auto-generated method stub
		int temp[]=new int[2];
		//using two loops to solve problem
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==target) {
					temp[0]=i;
					temp[1]=j;
					break;
				}
			}
		}
		return temp;
		
	}

	private static void printArray(int[] arr) {//print array
		// TODO Auto-generated method stub
		System.out.print("[");
		for(int i=0;i<arr.length-1;i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println(arr[arr.length-1]+"]");
	}
}
