package dtc;

import dtc.NaughtyServlet;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * This is all wrong wrong wrong
 * 
 */
public class NaughtyServletTest {

	  private static final int LOWER_BOUND = 0;
	  private static final int UPPER_BOUND = 1000;

	  @Test
	  public void next() {

	    NaughtyServlet.setUp();
	    NaughtyServlet.setCurrent(LOWER_BOUND);
	    
	    int first = NaughtyServlet.getCurrent();
	    int second = NaughtyServlet.next();

	    assertEquals(first + 1, second);
	  }

	  @Test
	  public void plus2() {

		  NaughtyServlet.setUp();
		  NaughtyServlet.setCurrent(LOWER_BOUND);
	    
	    int first = NaughtyServlet.getCurrent();
	    NaughtyServlet.next();
	    int second = NaughtyServlet.next();

	    assertEquals(first + 2, second);
	  }

	  @Test
	  public void plus3() {

		  NaughtyServlet.setUp();
		  NaughtyServlet.setCurrent(LOWER_BOUND);
	    
	    int first = NaughtyServlet.getCurrent();
	    NaughtyServlet.next();
	    NaughtyServlet.next();
	    int second = NaughtyServlet.next();

	    assertEquals(first + 3, second);
	  }

	  
	  @Test
	  public void previous() {

		  NaughtyServlet.setUp();
		  NaughtyServlet.setCurrent(UPPER_BOUND);
	    
	    int first = NaughtyServlet.getCurrent();
	    int second = NaughtyServlet.previous();

	    assertEquals(first - 1, second);
	  }

	  @Test
	  public void minus2() {

		  NaughtyServlet.setUp();
		  NaughtyServlet.setCurrent(UPPER_BOUND);
	    
	    int first = NaughtyServlet.getCurrent();
	    NaughtyServlet.previous();
	    int second = NaughtyServlet.previous();

	    assertEquals(first - 2, second);
	  }


	  @Test
	  public void minus3() {

		  NaughtyServlet.setUp();
		  NaughtyServlet.setCurrent(UPPER_BOUND);
	    
	    int first = NaughtyServlet.getCurrent();
	    NaughtyServlet.previous();
	    NaughtyServlet.previous();
	    int second = NaughtyServlet.previous();

	    assertEquals(first - 3, second);
	  }

	  @Test( expected = IllegalStateException.class )
	  public void exeedsUpperRange() {
		  NaughtyServlet.setUp();
		  NaughtyServlet.setCurrent(UPPER_BOUND);

	    int next = NaughtyServlet.next();
	  }

	  @Test( expected = IllegalStateException.class )
	  public void exeedsLowerRange() {
		  NaughtyServlet.setUp();
		  NaughtyServlet.setCurrent(LOWER_BOUND);

	    int previous = NaughtyServlet.previous();
	  }

	  
	  @Test
	  public void upperBound() {

		  NaughtyServlet.setUp();
		  NaughtyServlet.setCurrent(UPPER_BOUND);
	    int actual = NaughtyServlet.getCurrent();
	    
	    assertEquals(UPPER_BOUND, actual);
	  }

	  @Test
	  public void lowerBound() {

		  NaughtyServlet.setUp();
		  NaughtyServlet.setCurrent(LOWER_BOUND);
	    int actual = NaughtyServlet.getCurrent();
	    
	    assertEquals(LOWER_BOUND, actual);
	  }

	  @Test
	  public void testFail() { 
	    assertEquals(1, 2);
	  }
}
