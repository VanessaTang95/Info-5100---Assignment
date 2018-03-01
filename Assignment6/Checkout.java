package assignment6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Checkout {
	private DessertItem[] dessertitem;
	private final int MAX=100;
	private final int REI_WIDTH=40;
	int number=0;
	public Checkout() {
		dessertitem=new DessertItem[MAX];
		number=0;
	}
	
	public int numberofItems() {
		return number;
	}
	
	public void enterItem(DessertItem item) {
		this.dessertitem[number]=item;
		number++;
	}
	
	
	public void clear() {
		for(DessertItem e:dessertitem) {
			e=null;
		}
		number=0;
	}
	
	public int totalCost() {
		int sum=0;
		for(int i=0;i< number;i++) {
			sum+=dessertitem[i].getCost();
		}
		return sum;
	}
	
	public int totalTax() {
		return (int) (100*(DessertShoppe.Taxrate));
	}
	
	public String toString() {
		String output=" ";
		output+="\t"+DessertShoppe.Name+"\n";
		output+="\t";
		for(int i=0;i<DessertShoppe.Name.length();i++) {
			output+="-";
		}
		output+="\n";
		
		for(int j=0;j<number;j++) {
			String n=dessertitem[j].getName();//printout name for each item
			String c=DessertShoppe.cents2dollarsAndCents(dessertitem[j].getCost());//printout prize for each item
			
			if(c.length()>DessertShoppe.COST_WIDTH) {
				c=c.substring(0, DessertShoppe.COST_WIDTH);
			}
			
			if(dessertitem[j] instanceof Candy) {
				output+=((Candy)dessertitem[j]).getWeight()+" lbs. @ "+DessertShoppe.cents2dollarsAndCents(((Candy)dessertitem[j]).getPriceperpound())+"/lb\n";
				while(n.length()<REI_WIDTH-c.length()) {
					n+=" ";
				}
				output+=n+c+"\n";
			}
			else if(dessertitem[j] instanceof Cookie) {
				output+=((Cookie)dessertitem[j]).getNumber()+" @"+DessertShoppe.cents2dollarsAndCents(((Cookie)dessertitem[j]).getPrizeperdozen())+"/dz\n";
				while(n.length()<REI_WIDTH-c.length()) {
					n+=" ";
				}
				output+=n+c+"\n";
			}
			//Question mark: when I put IceCream before instanceof Sundae, 
			//even though the class type is Sundae, it still go on with IceCream, why?
			else if(dessertitem[j] instanceof Sundae){
				output+=((Sundae)dessertitem[j]).getToppingname()+" Sundae with\n";
				while(n.length()<REI_WIDTH-c.length()) {
					n+=" ";
				}
				output+=n+c+"\n";
			}
			else if(dessertitem[j] instanceof IceCream) {
				while(n.length()<REI_WIDTH-c.length()) {
					n+=" ";
				}
				output+=n+c+"\n";
			}
		}
		String show="\nTax";
		String tax=DessertShoppe.cents2dollarsAndCents(this.totalTax());
		while(show.length()<=REI_WIDTH-tax.length()) {
			show+=" ";
		}
		output+=show+tax;
		
		String totalCost=DessertShoppe.cents2dollarsAndCents(this.totalCost()+this.totalTax());
		show="\nTotal Cost";
		while(show.length()<=REI_WIDTH-totalCost.length()) {
			show+=" ";
		}
		output+=show+totalCost;
		
		return output;
	}
}
