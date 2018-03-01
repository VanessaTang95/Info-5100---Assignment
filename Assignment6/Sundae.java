package assignment6;

public class Sundae extends IceCream {
	private String toppingname;
	private int prizetopping;
	
	public Sundae(String iceCreamName, int iceCreamCost, String toppingName, int toppingCost) {
		// TODO Auto-generated constructor stub
		super(iceCreamName,iceCreamCost);
		this.toppingname=toppingName;
		this.prizetopping=toppingCost;
	}

	public String getToppingname() {
		return toppingname;
	}

/*
	public void setPrizetopping(int prizetopping) {
		this.prizetopping = prizetopping;
	}
*/
	public int getCost() {
		return this.prizetopping+super.getCost();
	}
}
