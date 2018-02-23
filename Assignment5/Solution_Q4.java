/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. (2 scores)
The brackets must close in the correct order, "()" and "()[]{}" are all valid 
but "(]" and "[)" are not.
There is the prototype you can work with. Please remember to write the whole class including main function .
class Solution {

public boolean isValid(String s) {

}


*/
package assignment5;

import java.util.Scanner;
import java.util.Stack;

public class Solution_Q4 {

	 public static boolean isValid(String s) {
	        if(s.length()%2==1) return false;
	     	char ch[]=s.toCharArray();
			Stack<Character> stack=new Stack<Character>();
			for(char e:ch) {
				if(e=='{') 	stack.push('}');
				else if(e=='[') 	stack.push(']');
				else if(e=='(') 	stack.push(')');
				else if(stack.isEmpty()||stack.pop()!=e)	return false;
				}
			return stack.isEmpty();

	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please input characters among \"(\",\")\",\"[\",\"]\",\"{\",\"}\" :");
		Scanner scan=new Scanner(System.in);
		String ch=scan.nextLine();
		System.out.println("Is "+ch+" valid:"+isValid(ch));
		
	}

}
