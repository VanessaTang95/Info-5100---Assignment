package extra;

/*
Write a Java function to remove vowels in a string.
 i. The function should take a string as input.
 ii. Should return the input string after omitting the vowels. 
Here is the prototype you can work with
public String removeVowelsFromString(String input){              }


*/
public class Solution {
	public static String removeVowelsFromString(String input){   
		if(input==null||input.length()<1) return null;
		
		String result="";
		char[] s=input.toCharArray();
		for(char e:s) {
			if(e!='a'&& e!='e'&& e!='i'&& e!='o'&& e!='u'&& e!='I'
					&& e!='E'&& e!='A'&& e!='O'&& e!='U') {
				result+=e;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String sample="I have an apple";
		System.out.println("Original String:"+sample);
		System.out.println("After remove all vowels:"+removeVowelsFromString(sample));
	}

}
