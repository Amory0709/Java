package exercises6;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTest {

	@Test
	public void testAdd() {
		assertEquals(0, Add.add(0, 0));
		assertEquals(1, Add.add(1, 0));
		assertEquals(2, Add.add(1, 1));
		assertEquals(5, Add.add(2, 3));
		//
		// write other test cases here:
		//
	}
	
	@Test
	public void testAddAny() {
		assertEquals(0, Add.addAny(2, -2));
		assertEquals(10, Add.addAny(10, 0));
		assertEquals(4, Add.addAny(2, 2));
		assertEquals(-4, Add.addAny(-2, -2));
	}

 }
