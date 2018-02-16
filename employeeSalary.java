// please wrtie th main function, otherwise the scores will be deducted next time.
// scores : 2 / 2;
/*
A: Write a java function to calculate the salary of an employee based on the
following rules.
i. function takes input of number of hours an employee worked and returns
the salary.
ii.The first 36 hours worked are paid at a rate of 15.0, then the next 5 hours
are paid at a rate of 15 * 1.5. Hours after that up to a max of 48 are paid at a
rate of 15 * 2 . Below is the prototype you can work with:
public double employeeSalary( double hours){
}
*/

package assignment;

public class employeeSalary {
	//define the properties of this class
	double sa;
	double hrs,hr1=36,hr2=41,hr3=48;
	double r1=15.0,r2=15*1.5,r3=15*2;
	
	public double employee_Salary(double hrs) {
		//three different conditions according to the description
		if(hrs<=hr1) {
			return hrs*r1;
		}else if(hrs<=hr2) {
			return hr1*r1+(hrs-hr1)*r2;
		}else if(hrs<=hr3) {
			return hr1*r1+(hr2-hr1)*r2+(hrs-hr2)*r3;
		}else
			return -1.0;
	}
    
}
