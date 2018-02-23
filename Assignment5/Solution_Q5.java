/*
4.	Create a calculator that can perform the following features. (Total Score 4)

i.	The calculator should be able to perform Addition, subtraction, multiplication, division. (Score 2)
ii.	Should be able to perform squareRoot, square, cube. (Score 1)
 iii. Should be able to convert ‘Fahrenheit-Celsius’ , ‘Feet-Inches’. (Score 1)

*/package assignment5;

class Calculator{
	//addition
	public void addition(double a, double b) {
		System.out.println(a+"+"+b+"="+(a+b));
	}
	public void addition(int a,int b) {
		System.out.println(a+"+"+b+"="+(a+b));
	}
	
	//subtraction
	public void subtraction(double a, double b) {
		System.out.println(a+"-"+b+"="+(a-b));
}
	public void subtraction(int a, int b) {
		System.out.println(a+"-"+b+"="+(a-b));
	}
	
	//multiplication
	public void multiplication(double a, double b) {
		System.out.println(a+"*"+b+"="+(a*b));
	}
	public void multiplication(int a, int b) {
		System.out.println(a+"*"+b+"="+(a*b));
	}
	
	//division
	public void division(double a, double b) {
		System.out.println(a+"/"+b+"="+(a/b));
	}
	public void division(int a, int b) {
		System.out.println(a+"/"+b+"="+((double)a/b));
	}
	
	//squareroot
	public void squareroot(double n) {
		System.out.println("The squareroot of "+n+" is: "+Math.sqrt(n));
	}
	
	//square
	public void square(int n) {
		System.out.println("The square of "+n+" is: "+n*n);

	}
	
	//cube
	public void cube(int n) {
		System.out.println("The cube of "+n+" is: "+n*n*n);
	}
	
	//‘Fahrenheit-Celsius’
	public void fToC(double t1) {
		double t2=(t1-32)*5/9;
		System.out.println(t1+" Fahrenheit is "+t2+" Celsius");
	}
    public void cToF(double t1) {
    	double t2=(t1*9/5+32);
    	System.out.println(t1+" Celsius is "+t2+" Fahernheit");	
    }
    
    //feet-inches
    public void fToI(double feet) {
    	double inches=12*feet;
    	System.out.println(feet+" feet is "+inches+" inches");
    }
    public void iToF(double inches) {
    	double feet=inches/12;
    	System.out.println(inches+" inches is "+feet+" feet");
    }
}

public class Solution_Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c=new Calculator();
		c.addition(3, 4);
		c.subtraction(5.4, 3);
		c.multiplication(2, 3);
		c.division(5, 4);
		c.squareroot(9);
		c.square(15);
		c.cube(3);
		c.fToC(74);
		c.cToF(33);
		c.fToI(12);
		c.iToF(54);
		
	}

}
