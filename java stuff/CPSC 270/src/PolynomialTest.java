import static org.junit.Assert.*;

import org.junit.Test;


public class PolynomialTest {
	
	@Test
	public void testConstructor() {
		Polynomial poly = new Polynomial(2);
		int expected = 2;
		int actual = poly.order();
		assertEquals("The order isnt 2", expected, actual);
	}
	
	@Test
	public void testGet(){
		Polynomial poly = new Polynomial(3);
		
		poly.set(2,33);
		
		int expected = 33;
		int actual= poly.get(2);
		
		assertEquals("Incorrect value", expected, actual);
}
	@Test(expected = IllegalArgumentException.class )
	public void testGetOutOfBounds(){
		Polynomial poly = new Polynomial(5);
		 Object expected = IllegalArgumentException.class;
		 Object actual = poly.get(7);
		 assertEquals("Did not throw IllegalArgumentException", expected,actual);
		}
	@Test(expected = IllegalArgumentException.class )
	public void testGetNegativeOutOfBounds(){
		Polynomial poly = new Polynomial(5);
		 Object expected = IllegalArgumentException.class;
		 Object actual = poly.get(-1);
		 assertEquals("Did not throw IllegalArgumentException", expected,actual);
		}
	@Test
	public void testGetZero(){
		Polynomial poly = new Polynomial(5);
		 int expected = 0;
		 int actual = poly.get(0);
		 assertEquals("Expected value", expected,actual);
		}
	
	
	@Test
	public void testOrder(){
		Polynomial poly = new Polynomial(4);
		
		int expected = 4;
		int actual = poly.order();
		assertEquals("Order was not correct", expected, actual);
		
	}
	
	@Test
	public void testSet(){
		Polynomial poly = new Polynomial(3);
		
		poly.set(2,12);
		
		int expected = 12;
		int actual = poly.get(2);
		assertEquals("Incorrect value", expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class )
	public void testSetLessThanZero(){
		Polynomial poly = new Polynomial(7);
		 Object expected = IllegalArgumentException.class;
		 poly.set(-1,22);
		 assertEquals("Did not throw IllegalArgumentException", expected,34);
		}
	@Test
	public void testSetGreaterThanPoly(){
		Polynomial poly = new Polynomial(3);
		
		poly.set(2,12);
		
		int expected = 12;
		int actual = poly.get(2);
		assertEquals("Incorrect value", expected, actual);
	}
	
	@Test
	public void testAddSameOrder() {
		Polynomial poly = new Polynomial(1);
		Polynomial poly2 = new Polynomial(1);
		
		poly.set(1,2);
		poly2.set(1, 2);
		
		Polynomial sum = poly.add(poly2);
		
		int expected = 1;
		int actual = sum.order();
		assertEquals("Incorrect order", expected, actual);
		
		int expected1 = poly.get(1) + poly2.get(1);
		int actual1 = sum.get(1);
		assertEquals("Incorrect value", expected1, actual1);
		
		int expected2 = poly.get(0) + poly2.get(0);
		int actual2 = sum.get(0);
		assertEquals("Incorrect value", expected2, actual2);
		
		
	}
	
	
	
	@Test
	public void testToString(){
		Polynomial p = new Polynomial();
		String actual = p.toString();
		String expected = "0";
		assertEquals("", expected, actual);
		
		Polynomial z = new Polynomial(3);
		z.set(3, 3);
		z.set(2, 2);
		z.set(1, 1);
		z.set(0, 0);
		actual = z.toString();
		expected = "3x3+2x2+x";
		assertEquals("", expected, actual);
	}
//		*This was test code*
		
//		Polynomial poly = new Polynomial(4);
//		poly.set(3, 1);
//		
//		String foo = new String();
//		
//		for(int i = poly.order(); i > 1; i--){
//			String boo = new String();
//			if(poly.get(i) != 0 && poly.get(i) != 1 && poly.get(i) != -1){
//				boo = Integer.toString(poly.get(i));
//			}
//			
//			if(poly.get(i) >= 0){
//				foo += boo + "x" + i + "+";
//			}
//			else{
//				foo += boo + "x" + i + "-";
//			}
//		}
//		
//		
//		String boo1 = new String();
//		if(poly.get(1) != 0 && poly.get(1) != -1 && poly.get(1) != 1){
//			boo1 = Integer.toString(poly.get(1));
//		}
//	foo += boo1 + "x";
//	
//	
//		String expected = "x4+x3+x2+x";
//		assertEquals("Incorrect String", expected, foo);
	}
//	@Test
//	public void testToString1(){
//		Polynomial poly = new Polynomial(2);
//		poly.set(1, -1);
//		poly.set(0,1);
//		
//		String foo = new String();
//		
//		for(int i = poly.order(); i > 1; i--){
//			String boo = new String();
//			if(poly.get(i) != 0 && poly.get(i) != 1 && poly.get(i) != -1){
//				boo = Integer.toString(poly.get(i));
//			}
//			
//			if(poly.get(i) >= 0){
//				foo += boo + "x" + i + "+";
//			}
//			else{
//				foo += boo + "x" + i + "-";
//			}
//		}
//		
//		
//		String boo1 = new String();
//		if(poly.get(1) != 0 && poly.get(1) != -1 && poly.get(1) != 1){
//			boo1 = Integer.toString(poly.get(1));
//		}
//	foo += boo1 + "x";
//	
//	
//		String expected = "x2-x+1";
//		assertEquals("Incorrect String", expected, foo);
//	}


