package dtc;

import dtc.Counter;

public class CounterRunner {

	public static void main(String[] args) {

		Counter counter = new Counter(0, 1000);
		counter.next();
		counter.previous();
		counter.getClass();
	}

}
