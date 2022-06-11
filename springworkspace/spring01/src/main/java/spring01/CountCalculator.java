package spring01;

public class CountCalculator extends Calculator{
	private final Counter counter;
	
	public CountCalculator(Counter counter) {
		this.counter = counter;
	}
	public Counter getCounter() {
		return counter;
	}
	@Override
	public int add(int n1, int n2) {
		counter.setAddCount(counter.getAddCount()+1);
		return super.add(n1, n2);
	}
	@Override
	public int min(int n1, int n2) {
		counter.setMinCount(counter.getMinCount()+1);
		return super.min(n1, n2);
	}
	@Override
	public int mul(int n1, int n2) {
		counter.setMulCount(counter.getMulCount()+1);
		return super.mul(n1, n2);
	}
	@Override
	public int div(int n1, int n2) {
		counter.setDivCount(counter.getDivCount()+1);
		return super.div(n1, n2);
	}
}
