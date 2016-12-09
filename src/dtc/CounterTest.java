package dtc;

import static org.junit.Assert.*;

import org.junit.Test;

import dtc.Counter;

/*
 * @author: Jan
 * 
 */
public class CounterTest {
  private static final int LOWER_BOUND = 0;
  private static final int UPPER_BOUND = 1000;

  @Test
  public void next() {

    Counter counter = setUp();
    counter.setCurrent(LOWER_BOUND);
    
    int first = counter.getCurrent();
    int second = counter.next();

    assertEquals(first + 1, second);
  }

  @Test
  public void plus2() {

    Counter counter = setUp();
    counter.setCurrent(LOWER_BOUND);
    
    int first = counter.getCurrent();
    counter.next();
    int second = counter.next();

    assertEquals(first + 2, second);
  }

  @Test
  public void plus3() {

    Counter counter = setUp();
    counter.setCurrent(LOWER_BOUND);
    
    int first = counter.getCurrent();
    counter.next();
    counter.next();
    int second = counter.next();

    assertEquals(first + 3, second);
  }

  
  @Test
  public void previous() {

    Counter counter = setUp();
    counter.setCurrent(UPPER_BOUND);
    
    int first = counter.getCurrent();
    int second = counter.previous();

    assertEquals(first - 1, second);
  }

  @Test
  public void minus2() {

    Counter counter = setUp();
    counter.setCurrent(UPPER_BOUND);
    
    int first = counter.getCurrent();
    counter.previous();
    int second = counter.previous();

    assertEquals(first - 2, second);
  }


  @Test
  public void minus3() {

    Counter counter = setUp();
    counter.setCurrent(UPPER_BOUND);
    
    int first = counter.getCurrent();
    counter.previous();
    counter.previous();
    int second = counter.previous();

    assertEquals(first - 3, second);
  }

  @Test( expected = IllegalStateException.class )
  public void exeedsUpperRange() {
    Counter counter = setUp();
    counter.setCurrent(UPPER_BOUND);

    int next = counter.next();
  }

  @Test( expected = IllegalStateException.class )
  public void exeedsLowerRange() {
    Counter counter = setUp();
    counter.setCurrent(LOWER_BOUND);

    int previous = counter.previous();
  }

  
  @Test
  public void upperBound() {

    Counter counter = setUp();
    counter.setCurrent(UPPER_BOUND);
    int actual = counter.getCurrent();
    
    assertEquals(UPPER_BOUND, actual);
  }

  @Test
  public void lowerBound() {

    Counter counter = setUp();
    counter.setCurrent(LOWER_BOUND);
    int actual = counter.getCurrent();
    
    assertEquals(LOWER_BOUND, actual);
  }

  private Counter setUp() {
    return new Counter(LOWER_BOUND, UPPER_BOUND);
  }

}
