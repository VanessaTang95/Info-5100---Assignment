/**
Problem:Write a java function to print all perfect number between 1 and n.
Perfect number is a positive integer which is equal to the sum of its proper
positive divisors.
ii. For example: 6 is the first perfect number, Proper divisors of 6 are 1, 2, 3.
Sum of its proper divisors = 1 + 2 + 3 = 6.
Here is the prototype you can work with
public void printPerfectNumbers( int n){

*/

package assignment;

import java.util.Scanner;

public class PerfectNumber {

	public static void printPerfectNumbers(int n) {
		for(int m=1;m<=n;m++) {// print perfect number between 1~n
			double sum=0.0;
			for(int i=1;i<=Math.sqrt(m);i++) {//find the proper divisor
				if((m%i==0)&&(m!=i)) {
					if(i==1) {
						sum+=i;
					}else if(i==Math.sqrt(m)){
						sum+=i;
					}else{
						sum+=(i+m/i);
					}
				}	
			}
			if(sum==m) {
				System.out.print(m+" ");
			}
		}
	}

	public static void main(String args[]) {
		System.out.println("Print the perfect number from 1~n;please set the value of n:");
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		System.out.println("Perfect number from 1~"+num+" is:");
		printPerfectNumbers(num);
		
	}


}

		