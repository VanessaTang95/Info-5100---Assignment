package problem3;

/*
. Implement a class called Tool. It should have an int field called strength
and a char field called type. You may make them either private or
protected. The Tool class should also contain the function void
setStrength(int), which sets the strength for the Tool.
*/
class Tool{
	protected int strength;
	protected char type;
	public Tool() {this.strength=0;}
	public Tool(int strength) {
		this.strength=strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
		
	}