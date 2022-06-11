package spring01;

public class Counter {
	private int addCount;
	private int minCount;
	private int mulCount;
	private int divCount;
	
	public Counter() {
		addCount = 0;
		minCount = 0;
		mulCount = 0;
		divCount = 0;
	}
	
	public int getAddCount() {
		return addCount;
	}

	public void setAddCount(int addCount) {
		this.addCount = addCount;
	}

	public int getMinCount() {
		return minCount;
	}

	public void setMinCount(int minCount) {
		this.minCount = minCount;
	}

	public int getMulCount() {
		return mulCount;
	}

	public void setMulCount(int mulCount) {
		this.mulCount = mulCount;
	}

	public int getDivCount() {
		return divCount;
	}

	public void setDivCount(int divCount) {
		this.divCount = divCount;
	}
}
