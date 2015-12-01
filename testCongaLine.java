import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;


public class testCongaLine {
	@SuppressWarnings("unchecked")
	
//========================================================
//=================== TEST LINKEDLIST ====================
//========================================================

	//--------------------
	// TESTS FOR getLast()
	//--------------------
	
	/* 
	 * 	If LinkedList contains no nodes then getLast() should return null
	 */
	@Test 
	public void testLastNodeWithZeroNodes(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		Node x = list.getLast();
		assertNull(x);
	}
	
	/*
	 * 	If LinkedList contains 1 node then getLast should return that exact node
	 */
	@Test
	public void testLastNodeWithOneNode(){
		LinkedList<String> list = new LinkedList<String>();
		Node<String> n1 = Mockito.mock(Node.class);
		list.add(n1);
		Node<String> lastNode = list.getLast();
		assertSame(n1, lastNode);
	}
	
	/*
	 * 	If three nodes are added to a LinkedList
	 *  then getLast should return the last Node added to the list
	 */
	@Test
	public void testLastNodeWithThreeNodes(){
		LinkedList<String> list = new LinkedList<String>();
		Node<String> n1 = new Node<String>("Dan");
		Node<String> n2 = new Node<String>("Tyler");
		Node<String> n3 = new Node<String>("Kevin");
		list.add(n1);
		list.add(n2);
		list.add(n3);
		
		Node<String> lastNode = list.getLast();
		assertSame(n3, lastNode);
	}
	
	//-----------------
	// TESTS FOR size()
	//-----------------
	
	/*
	 * Test that if a LinkedList contains no nodes then size should return 0
	 */
	@Test
	public void testSizeOfEmptyList(){
		LinkedList<String> list = new LinkedList<String>();
		int size = list.size();
		assertEquals(size, 0);
	}
	
	/*
	 * 	Add 2 Nodes to LinkedList. Check that size of LinkedList is 2
	 */
	@Test
	public void testSize(){
		LinkedList<String> list = new LinkedList<String>();
		Node<String> n1 = new Node("dan");
		Node<String> n2 = new Node("tyler");
		list.add(n1);
		list.add(n2);
		int size = list.size();
		assertEquals(size,2);
	}
	
	//--------------------
	// TESTS FOR indexOf()
	//--------------------
	
	/*
	 * 	If LinkedList does not contain a string
	 *  then indexOf() should return -1
	 */
	@Test
	public void testIndexOfObjectNoElements(){
		LinkedList<String> list = new LinkedList<String>();
		int index = list.indexOf("Dan");
		assertEquals(index, -1);
	}
	
	/*
	 * 	If we add values 0-100 to a LinkedList
	 *  then the index of any value should be value
	 */
	@Test
	public void testIndexOfManyIntegers(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i=0; i<100; i++){
			Node<Integer> n = new Node<Integer>(new Integer(i));
			list.add(n);
		}
		int index = list.indexOf(98);
		assertEquals(98, index);
	}
	
	/*
	 * 	If a single string is added to a LinkedList
	 *  then the index of that string should be 0
	 */
	@Test
	public void testIndexOfOneString(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("Charlotte");
		int index = list.indexOf("Charlotte");
		assertEquals(index,0);
	}
	
	/*
	 *	If a LinkedList contains 1 value then the index of that 
	 *	value in the LinkedList should be 0
	 */
	@Test
	public void testIndexOfOneInteger(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		int index = list.indexOf(10);
		assertEquals(index,0);
	}
	

	//--------------------
	// TESTS FOR remove()
	//--------------------
	
	/*
	 *	If we add 100 values to a LinkedList and remove only 1 of those values
	 *  then the other 99 values should still exist in the LinkedList
	 */
	@Test
	public void testRemoveOneValue(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		boolean pass = true;
		
		for(int i=0; i<100; i++){
			list.add(new Integer(i));
		}
		list.remove(0);
		
		for(int i=1; i<100; i++){
			if(list.indexOf(i) == -1){
				pass = false;
			}
		}
		assertTrue(pass);
	}
	
	/*
	 * 	If we add the String value twice, and remove the String once
	 *  then the LinkedList should still contain the String
	 */
	@Test
	public void testRemoveDuplicateValue(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("thanksgiving");
		list.add("thanksgiving");
		list.remove("thanksgiving");
		int index = list.indexOf("thanksgiving");
		assertNotEquals(index, -1);
	}
	
	/*
	 * 	If we add 100 values to the LinkedList and remove every value
	 *  then the linkedList should contain no values
	 */
	@Test
	public void testRemoveAllValues(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i=0; i<100; i++){
			list.add(new Integer(i));
		}
		
		for(int i=0; i<100; i++){
			list.remove(i);
		}
		int size = list.size();
		assertEquals(size, 0);
	}
	
	
	/*
	 * 	If we add the same string twice to a Linkedlist, and remove the 
	 *	string once then only the first occurrence of the LinkedList 
	 *	should be removed.
	 */
	@Test
	public void testRemoveFirstOccurence(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("wendys");
		list.add("mcdonalds");
		list.add("arbys");
		list.add("wendys");
		list.add("burger king");
		list.add("bostons market");
		
		list.remove("wendys");
		
		int index = list.indexOf("wendys");
		assertEquals(2, index);
	}
	
	/*
	 * 	If a string that exists only once in the LinkedList is removed,
	 *  then the LinkedList should no longer contain that element
	 */
	@Test
	public void testRemoveElement(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("wendys");
		list.add("mcdonalds");
		list.add("arbys");
		
		list.remove("arbys");
		
		int index = list.indexOf("arbys");
		assertEquals(-1, index);
	}
	
	/*
	 * If the first element of a LinkedList is removed then the element 
	 * after the first element should now be the first element
	 */
	@Test
	public void testRemoveFirstElement(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("hello");
		list.add("world");
		list.add("programming");
		
		list.remove("hello");
		int index = list.indexOf("world");
		assertEquals(0, index);
	}
	
	
	//-----------------
	// TESTS FOR get()
	//-----------------
	
	/*
	 * 	If we add a string to a LinkedList at the 0th index
	 *  Then if we get an element from the LinkedList at the 0th index
	 *  the strings should be equal
	 */
	@Test
	public void testGetElementAtFirstIndex(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("Elf");
		Object name = list.get(0);
		assertEquals("Elf", name);
	}
	
	/*
	 * 	If we try and get an element at an index that is out of bounds
	 *  Then IndexOutOfBoundsException exception should be thrown
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetElementThatDoesNotExists() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("snow");
		list.add("angel");
		list.get(10);
	}
	
	
	//---------------------
	// TESTS FOR addFirst()
	//---------------------
	
	/*
	 * 	If the list is empty and you call addFirst on that list
	 *  then list should set the added object as root of the list
	 */
	@Test
	public void testAddFirstOnEmptyList(){
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("Walking Dead");
		Object root = list.get(0);
		assertEquals("Walking Dead", root);
	}
	
	/*
	 * 	If you add first to a list that has a few items in it
	 *  then the size of the list should increase
	 */
	@Test
	public void testAddFirst(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("Carl");
		list.add("Rick");
		list.add("Lori");
		
		int orgSize = list.size();
		list.addFirst("Glen");
		int newSize = list.size();
		
		assertTrue(newSize > orgSize);
	}
	
	//--------------------
	// TESTS FOR addLast()
	//--------------------
	
	/*
	 * 	If you call addLast on an empty list then addlast() should 
	 *	append the new object as root of that list
	 */
	@Test
	public void testAddLastToEmptyList(){
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("Walking Dead");
		Object root = list.get(0);
		assertEquals("Walking Dead", root);
	}
	
	/*
	 * 	If you call addLast on a list that has a few items
	 *  then addLast should append the new object as the very last item
	 */
	@Test
	public void testAddLastToList(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("Carl");
		list.add("Rick");
		list.add("Lori");
		
		int orgSize = list.size();
		list.addLast("Glen");
		int newSize = list.size();
		Node lastItem = list.getLast();
		
		assertEquals(lastItem.getVal(), "Glen");
	}
	
	//------------------
	// TESTS FOR clear()
	//------------------
	
	/*
	 * 	If you call clear on on a LinkedList
	 *  then the side of the list should be 0
	 */
	@Test
	public void testClearSize(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i=0; i<100; i++){
			list.add(new Integer(i));
		}
		list.clear();
		int size = list.size();
		assertEquals(0, size);
	}
	
	
	//========================================================
	//=================== TEST CONGALINE =====================
	//========================================================
	
	//------------------
	// TESTS FOR enter()
	//------------------
	
	/*
	 * 	If only 1 person enters the Conga line
	 *  then the amount of people in the conga line should be 1
	 */
	@Test
	public void TestEnterOnePerson(){
		CongaLine line = new CongaLine();
		line.enter("AJ");
		assertEquals(1, line.lineSize());
	} 
	
	
	//------------------------
	// TESTS FOR enterBehind()
	//------------------------
	
	/*
	 *  If AJ enters behind DAN, then AJ should be holding 
	 *  the hips of DAN	
	 */
	@Test
	public void testEnterBehind(){
		CongaLine line = new CongaLine();
		line.enter("DAN");
		line.enterBehind("AJ", "DAN");
		
		String AJIsHoldingHipsOf = line.holdingHipsOf("AJ");
		assertEquals("DAN", AJIsHoldingHipsOf);
	}
	
	/*
	 * If a person tries to enter the conga line behind nobody 
	 * then enterBehind will return false
	 */
	@Test
	public void testEnterBehindNobody(){
		CongaLine line = new CongaLine();
		boolean success = line.enterBehind("Dan", null);
		assertFalse(success);
	}
	
	/*
	 * If a person tries to enter the conga line behind someone who is 
	 * not in the line then enterBehind will return false
	 */
	@Test
	public void testEnterBehindSomeoneNotInLine(){
		CongaLine line = new CongaLine();
		line.enter("Ashley");
		line.enter("Charlotte");
		boolean success = line.enterBehind("Dan", "AJ");
		
		assertFalse(success);
	}
	
	
	//------------------
	// TESTS FOR leave()
	//------------------
	
	/*
	 * 	If a person leaves the line, then the size of the line should 
	 *	decrease by 1
	 */
	@Test()
	public void testLeaveSize(){
		CongaLine line = new CongaLine();
		line.enter("Glen");
		line.enter("Rick");
		line.enter("Carl");
		line.enter("Shane");
		int lineSizeOrg = line.lineSize();
		
		line.leave("Carl");
		int lineSizeAfter = line.lineSize();
		
		assertTrue(lineSizeAfter == lineSizeOrg-1);
	}
	
	
	//--------------------------
	// TESTS FOR holdingHipsOf()
	//--------------------------
	
	/*
	 * 	If the person at the front of the line tries to hold the hips of someone
	 *  then holdingHipsOf will return "No Partner!"
	 */
	@Test
	public void testHoldingHipsOf(){
		CongaLine line = new CongaLine();
		line.enter("Claude Giroux");
		line.enter("Scott Hartnell");
		line.enter("Wayne Simmonds");
		
		String partner = line.holdingHipsOf("Claude Giroux");
		assertEquals("No Partner!", partner);
	}
	
	
	//--------------------
	// TESTS FOR seeLine()
	//--------------------
	
	/*
	 * 	Check that function seeLine() prints out the people in correct order
	 */
	@Test 
	public void testSeeLine(){
		CongaLine line = new CongaLine();
		line.enter("Charlotte");
		line.enter("Dan");
		line.enter("Shuqi");
		
		String lineSequence = line.seeLine();
		
		assertTrue(lineSequence.contains("Shuqi -> Dan -> Charlotte"));
	}
	
	 
	//---------------------
	// TESTS FOR lineSize()
	//---------------------
	
	/*
	 * If 100 people enter the line
	 * then the size of the line should be 100
	 * */
	public void testLineSize(){
		CongaLine line = new CongaLine();
		
		for(int i=0; i<100; i++){
			line.enter(String.valueOf(i));
		}
		int sizeOfLine = line.lineSize();
		assertEquals(100, sizeOfLine);
	}
	
	//---------------------
	// CongaLineDriver.java
	//---------------------
	@Test
	public void CongaLineDriver() { 
    	CongaLineDriver line = new CongaLineDriver();
    	String[]str = {};
    	line.main(str);
    	assertEquals(str.length, 0);
    }
}

