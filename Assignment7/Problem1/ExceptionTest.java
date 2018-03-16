package problem1;

public class ExceptionTest {

	public static void main(String[] args) throws MyIndexOutOfBoundException {
		int index=5;
		for(int i=0;i<=10;i++) {
			System.out.println(index);
			index++;
			if (index>=10) {
			MyIndexOutOfBoundException e=new MyIndexOutOfBoundException(index);
			throw e;
		}
		}

	}

}

/*
 * - Create your own MyIndexOutOfBoundException Class. It
should contain these parameters
◦ lowerBound - the lowest legal index value.
◦ upperBound - the highest legal index value.
◦ index - the current index value.
 * Test your code in main method, by creating an
indexOutOfBoundException. Output error message should be
like this:
 “Error Message: Index: 10, but Lower bound: 0, Upper
bound: 9” 
 */

class MyIndexOutOfBoundException extends Exception{
	int index;
	int lowerBound=0;
	int upperBound=9;
	
	public MyIndexOutOfBoundException(int index) {
		this.index=index;
	}
	
	public String toString() {
		return "\"Error Messege: Index: "+index+", but Lower bound: "+lowerBound+", Upper bound: "+upperBound+"\"";
	}
}