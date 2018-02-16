// scores :  2 / 2
/*
Given a string, find the length of the longest substring without repeating
characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. Note that the
answer must be a substring, "pwke" is a subsequence and not a substring
*/
package assignment;

import java.util.HashMap;

public class LongestSubstring {

	public static void longestSub(String str) {
	    
	    int maxLen = 0;
	    int index = 0;
	    int j = 0;

	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	/*use hashmap to store every element from the string, 
	 * when the map have the repeat element, jump out of loop,
	 * record the index of i and the length of substring
	
	*/
	    for (int i=0; i<str.length(); i++) {
	        map.clear();
	        map.put(str.charAt(i), 1);

	        for (j=i+1; j<str.length(); j++) {
	            if (map.get(str.charAt(j)) != null) {
	                break;
	            }
	            map.put(str.charAt(j), 1);
	        }

	        if (j-i > maxLen) {
	            maxLen = j-i;
	            index = i;
	        }
	    }

	     System.out.println(str.substring(index, index+maxLen)+","+maxLen);
	}           
	
	
	public static void main(String[] args) 
		    {
		        String str = "bbbbbbb";
		        System.out.println("The input string is "+str);
		        System.out.println("Substring and it's length:");
		        longestSub(str);
		    }

	}

