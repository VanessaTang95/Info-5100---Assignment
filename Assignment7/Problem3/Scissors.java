package problem3;

class Scissors extends Tool{
	Scissors(int strength){
		super(strength);
		this.type='s';
	}
	public boolean fight(Tool t) {
		int temp;
		if(t instanceof Rock) {
			temp=this.strength/2;
			return temp>t.strength;
		}
		if(t instanceof Paper) {
			temp=this.strength*2;
			return temp>t.strength;
		}
		return false;
	}

}