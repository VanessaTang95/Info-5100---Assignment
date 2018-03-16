package problem4;

class Interval{
	int start;
	int end;
	Interval(){this.start=0;this.end=0;}
	Interval(int start, int end){
		this.start=start;
		this.end=end;
	}
	public String toString() {
		return "["+this.start+","+end+"]";
	}
}