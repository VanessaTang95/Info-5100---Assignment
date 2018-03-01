package assignment6;

public class IceCream extends DessertItem {
	protected int cost;
	
	public IceCream(String name, int cost) {
		super(name);
		this.cost=cost;
	}
	public IceCream() {
		this("",0);
	}
/*
	public void setCost(int cost) {
		this.cost = cost;
	}
*/
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

}
