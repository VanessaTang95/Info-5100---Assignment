package problem3;

class Paper extends Tool{
	Paper(int strength){
		super(strength);
		this.type='p';
	}
	public boolean fight(Tool t) {
		int temp;
		if(t instanceof Rock) {
			temp=this.strength*2;
			return temp>t.strength;
		}
		if(t instanceof Scissors) {
			temp=this.strength/2;
			return temp>t.strength;
		}
		return false;
	}
}