package problem3;

class Rock extends Tool{
	Rock(int strength) {
		super(strength);
		this.type='r';
	}
	public boolean fight(Tool t) {
		//in case it will change the strength permanently
		int temp;
		if(t instanceof Paper) {
			temp=this.strength/2;
			return temp>t.strength;
		}
		if(t instanceof Scissors) {
			temp=this.strength*2;
			return temp>t.strength;
		}
		return false;
	}
}