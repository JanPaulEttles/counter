package dtc;

/*
 * @author: Jan
 * 
 */
public class Counter {

	public int lowerBound;
	public int upperBound;
	public int count;
	
	public Counter() {
		this(0, 0);
	}

	public Counter(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.count = 0;
	}

	public int next() {
		return increment();
	}
	
	public int previous() {
		return decrement();
	}

	public int getCurrent() {
		return getCount();
	}

	public void setCurrent(int current) {
		setCount(current);
	}
	
	private int increment() 
			throws IllegalStateException {
			
			if(count + 1 > upperBound) {
				throw new IllegalStateException("already at upper bound");
			}
			return ++count;
		}

	private int decrement() 
		throws IllegalStateException {
		
		if(count - 1 < lowerBound) {
			throw new IllegalStateException("already at lower bound");
		}
		return --count;
	}

	
	private void setCount(int count) {
		this.count = count;
	}

	private int getCount() {
		return count;
	}
}
