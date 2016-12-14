package dtc;

import dtc.Counter;

public class CounterRunner {

	private static Counter counter = new Counter(0, 1000);

	public static void main(String[] args) {

		counter.next();
		counter.previous();
		counter.getClass();
	}
	

}
