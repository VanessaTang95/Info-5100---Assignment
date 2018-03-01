/*
The DessertShoppe Class
The DessertShoppe class  contains constants such as 
the tax rate as well the name of the store, the maximum size of an item name and the width used to display the costs of the items on the receipt. 
Your code should use these constants wherever necessary! 
The DessertShoppe class also contains the cents2dollarsAndCentsmethod 
which takes an integer number of cents and returns it as a String formatted in dollars and cents.
 For example, 105 cents would be returned as "1.05".
*/
package assignment6;

public class DessertShoppe {
	//constant...? 
	protected final static String Name="M & M Dessert Shoppe";
	protected final static double Taxrate=0.87;
	protected final static int MAX_NAME_SIZE=30;
	protected final static int COST_WIDTH=8;
		
	public static String cents2dollarsAndCents(int cents) {
		String results="";
		if(cents<0) {
			return "invalid price";
		}
		int dollars=cents/100;
		cents=cents%100;
		// in the sample, if dollar <0,don't print
		if(dollars>0) {
			results+=dollars;
		}
		results+=".";
		
		if(cents<10) {
			results+="0"+cents;
		}else {
			results+=cents;
		}
		
		
		return results;
	}
	
	
}
