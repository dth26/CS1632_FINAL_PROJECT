import static org.junit.Assert.*;

import org.junit.Test;

public class testCongaLine {

	//////////////////////////////////////////////////////////////////////////
	////
	//// TESTS FOR enter
	////
	//////////////////////////////////////////////////////////////////////////
	/*
	 * 	If only 1 person enters the Conga line
	 *  then the amount of people in the conga line should be 1
	 * */
	@Test
	public void TestEnterOnePerson(){
		CongaLine line = new CongaLine();
		line.enter("AJ");
		assertEquals(1, line.lineSize());
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	////
	//// TESTS FOR enterBehind
	////
	//////////////////////////////////////////////////////////////////////////
	/*
	 *  If AJ enters behind DAN
	 *  Then AJ should be holding the hips of DAN	
	 * */
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
	 * 
	 * */
	@Test
	public void testEnterBehindNobody(){
		CongaLine line = new CongaLine();
		boolean success = line.enterBehind("Dan", null);
		assertFalse(success);
	}
	
	/*
	 * If a person tries to enter the conga line behind someone who is not in the line
	 * then enterBehind will return false
	 * */
	@Test
	public void testEnterBehindSomeoneNotInLine(){
		CongaLine line = new CongaLine();
		line.enter("Ashley");
		line.enter("Charlotte");
		boolean success = line.enterBehind("Dan", "AJ");
		
		assertFalse(success);
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	////
	//// TESTS FOR leave
	////
	//////////////////////////////////////////////////////////////////////////
	/*
	 * 	If a person leaves the line 
	 *  Then the size of the line should decrease by 1
	 * */
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
	
	
	//////////////////////////////////////////////////////////////////////////
	////
	//// TESTS FOR holdingHipsOf
	////
	//////////////////////////////////////////////////////////////////////////
	
	/*
	 * 	If the person at the front of the line tries to hold the hips of someone
	 *  then holdingHipsOf will return "No Partner!"
	 * */
	@Test
	public void testHoldingHipsOf(){
		CongaLine line = new CongaLine();
		line.enter("Claude Giroux");
		line.enter("Scott Harntell");
		line.enter("Wayne Simmonds");
		
		String partner = line.holdingHipsOf("Claude Giroux");
		assertEquals("No Partner!", partner);
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	////
	//// TESTS FOR seeLine
	////
	//////////////////////////////////////////////////////////////////////////
	
	/*
	 * 	Check that function seeLine() prints out the people in correct order
	 * */
	@Test
	public void testSeeLine(){
		CongaLine line = new CongaLine();
		line.enter("Charlotte");
		line.enter("Dan");
		line.enter("Shuqi");
		
		String lineSequence = line.seeLine();
		
		assertTrue(lineSequence.contains("Shuqi -> Dan -> Charlotte"));
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	////
	//// TESTS FOR lineSize
	////
	//////////////////////////////////////////////////////////////////////////
	
	/*
	 * If 100 people enter the line
	 * then the size of the line should be 100
	 * 	
	 * */
	public void testLineSize(){
		CongaLine line = new CongaLine();
		
		for(int i=0; i<100; i++){
			line.enter(String.valueOf(i));
		}
		
		int sizeOfLine = line.lineSize();
		
		assertEquals(100, sizeOfLine);
	}
}

























