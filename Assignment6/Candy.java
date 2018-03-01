package assignment6;

public class Candy extends DessertItem {
	private double weight;
	private int priceperpound; //cents
	
	public Candy(String string, double d, int i) {
		super(string);
		this.weight=d;
		this.priceperpound=i;
	}

	public double getWeight() {
		return weight;
	}
/*
	public void setWeight(double weight) {
		this.weight = weight;
	}
*/
	public int getPriceperpound() {
		return priceperpound;
	}
/*
	public void setPriceperpound(int priceperpound) {
		this.priceperpound = priceperpound;
	}
*/
	@Override
	public int getCost() {
		return (int) Math.round(this.priceperpound*this.weight);
	}

}
