import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedLastTest {

	@Test 
	public void testAdd(){
		LinkedLast <String> list = new LinkedLast<String>();
		list.add("zero");
		list.add("one");
		list.add("two");
		
		int actual = list.getSize();
		int expected = 3;
		assertEquals(expected, actual);
		
	}
	@Test
	public void testClearAll(){
		LinkedLast <String> list = new LinkedLast<String>();
		list.add("zero");
		list.add("one");
		list.add("two");
		list.clear();
		int actual = list.getSize();
		int expected = 0;
		assertEquals(expected, actual);
	}
	@Test
	public void testDoesNotContain(){
		LinkedLast <String> list = new LinkedLast<String>();
		list.add("zero");
		list.add("one");
		list.add("two");
		boolean actual= list.contains("five");
		boolean expected = false;
		assertEquals(expected, actual);
	}
	@Test
	public void testGet(){
		LinkedLast <Integer> list = new LinkedLast<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		int actual = list.get(3);
		int expected = 4;
		assertEquals(expected, actual);
	}
	@Test
	public void testGetWithOne(){
		LinkedLast <Integer> list = new LinkedLast<Integer>();
		list.add(1);
		int actual = list.get(0);
		int expected = 1;
		assertEquals(expected, actual);
	}
	@Test
	public void testGetSize(){
		LinkedLast <Integer> list = new LinkedLast<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		int actual = list.getSize();
		int expected = 4;
		assertEquals(expected, actual);
		
	}
	@Test
	public void testGetSizeEmptyList(){
		LinkedLast<Integer> list = new LinkedLast<Integer>();
		int actual = list.getSize();
		int expected = 0;
		assertEquals(expected, actual);
		
		list.add(1);
		list.add(2);
		list.clear();
		actual = list.getSize();
		expected = 0;
		assertEquals(expected, actual);
	}
	@Test
	public void testisEmpty(){
		LinkedLast<Integer> list = new LinkedLast<Integer>();
		boolean actual = list.isEmpty();
		boolean expected = true;
		assertEquals(expected, actual);
	}
	@Test
	public void testNotEmpty(){
		LinkedLast<Integer> list = new LinkedLast<Integer>();
		list.add(1);
		boolean actual = list.isEmpty();
		boolean expected = false;
		assertEquals(expected, actual);
	}
	@Test
	public void testSet(){
		LinkedLast <Integer> list = new LinkedLast<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.set(3, 0);
		int actual = list.get(3);
		int expected = 0;
		assertEquals(expected, actual);
		
		
	}
	@Test
	public void testRemove(){
		LinkedLast<Integer> list= new LinkedLast<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.set(3, 0);
		list.remove(0);
		int actual = list.get(3);
		int expected = 0;
		assertEquals(expected, actual);
	}
	@Test 
	public void testIndexOf(){
		LinkedLast<Integer> list= new LinkedLast<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.set(3, 0);
		int actual = list.indexOf(0);
		int expected = 4;
		assertEquals(expected, actual);
		
		
	}
	@Test 
	public void testIndexOfNot(){
		LinkedLast<Integer> list= new LinkedLast<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.set(3, 0);
		int actual = list.indexOf(12);
		int expected = -1;
		assertEquals(expected, actual);
		
		
	}
}
