package assignment6;

public class Cookie extends DessertItem {
	private int number;
	private int prizeperdozen;
	
	public Cookie(String name, int i, int j) {//constructor
		super(name);// inherit name from DessertItem
		this.number=i;
		this.prizeperdozen=j;
	}

	public int getNumber() {
		return number;
	}

/*	public void setNumber(int number) {
		this.number = number;
	}
*/
	public int getPrizeperdozen() {
		return prizeperdozen;
	}

/*	public void setPrizeperdozen(int prizeperdozen) {
		this.prizeperdozen = prizeperdozen;
	}
*/
	@Override
	public int getCost() {
			return (int)Math.round(this.number/12.0*this.prizeperdozen);
	}

}
