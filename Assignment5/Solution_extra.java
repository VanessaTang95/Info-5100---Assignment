//scores: 2 / 2

/*
In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", 
a move consists of either replacing one occurrence of "XL" with "LX", 
or replacing one occurrence of "RX" with "XR". 
Given the starting string start and the ending string end, 
return True if and only if there exists a sequence of moves to transform one string to the other.(2 scores)

Example:
start="RXXLRXRXL" end="XRLXXRRLX"
output:true
*/
package assignment5;

import java.util.Scanner;

public class Solution_extra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("please input start string using 'X'/'L'/'R':");
		Scanner scanner=new Scanner(System.in);
		String start=scanner.nextLine();
		System.out.println("please input end string using 'X'/'L'/'R':");
		String end=scanner.nextLine();
		System.out.println(isGameTrue(start,end));
	}

	private static boolean isGameTrue(String start, String end) {
		if(start==end) return true;
		//by observing the start and end, find that if we delete all X, two string should be same
		if(!(start.replace("X", "").equals(end.replace("X", "")))) return false;
		//L could only move to left, X could only be move to right
		//by compare their index in two string, we can know whether start can change to end
		char s[]=start.toCharArray();
		char e[]=end.toCharArray();
		int i=0;
		int j=0;
		while(i<s.length && j<e.length) {
			while(i<s.length && s[i]=='X') i++;
			while(j<e.length && e[j]=='X') j++;
			if(i==s.length || j==e.length) break;
			//if the index of R in the start bigger than index of R in the end, R move to left side, fail
			if(s[i]=='R' && i>j) return false;			
			//L could only move to the left, so if the index of L in start is smaller than that in end, L move to right, fail
			if(s[i]=='L' && i<j) return false;
			//if none of the situation happens, we should check the next character
			i++;
			j++;
		}
		return true;	
	}

}
