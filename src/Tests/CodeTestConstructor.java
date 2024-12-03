package TestCode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import types.BinaryColour;
import types.Code;
import types.MultiColour;

class CodeTestConstructor {

	private Code codeToTest;

	@Test
	void testeConstrutor1() {

		ArrayList<MultiColour> start = new ArrayList<MultiColour>();

		start.add(MultiColour.BLUE);
		start.add(MultiColour.BLUE);
		start.add(MultiColour.BLUE);
		start.add(MultiColour.BLUE);

		codeToTest = new Code(start);

		String expected = "[B, B, B, B]";
		String actual = codeToTest.toString();

		assertEquals(actual, expected);


	}
	
	@Test
	void testeConstrutor2() {

		ArrayList<MultiColour> start = new ArrayList<MultiColour>();

		start.add(MultiColour.GREEN);
		start.add(MultiColour.BLUE);
		start.add(MultiColour.BLUE);
		start.add(MultiColour.BLUE);

		codeToTest = new Code(start);

		String expected = "[G, B, B, B]";
		String actual = codeToTest.toString();

		assertEquals(actual, expected);


	}
	
	@Test
	void testeConstrutor3() {

		ArrayList<MultiColour> start = new ArrayList<MultiColour>();

		start.add(MultiColour.GREEN);
		start.add(MultiColour.BLUE);
		start.add(MultiColour.BLUE);
		start.add(MultiColour.BLUE);
		start.add(MultiColour.GREEN);
		start.add(MultiColour.BLUE);
		start.add(MultiColour.BLUE);
		start.add(MultiColour.BLUE);

		codeToTest = new Code(start);

		String expected = "[G, B, B, B, G, B, B, B]";
		String actual = codeToTest.toString();

		assertEquals(actual, expected);


	}
	
	@Test
	void testeConstrutor4() {

		ArrayList<BinaryColour> start = new ArrayList<BinaryColour>();

		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		
		codeToTest = new Code(start);

		String expected = "[B, B, B, B]";
		String actual = codeToTest.toString();

		assertEquals(actual, expected);


	}
	
	@Test
	void testeConstrutor5() {

		ArrayList<BinaryColour> start = new ArrayList<BinaryColour>();

		start.add(BinaryColour.WHITE);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		

		codeToTest = new Code(start);

		String expected = "[W, B, B, B]";
		String actual = codeToTest.toString();

		assertEquals(actual, expected);


	}
	
	@Test
	void testeConstrutor6() {

		ArrayList<BinaryColour> start = new ArrayList<BinaryColour>();

		start.add(BinaryColour.WHITE);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.WHITE);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);

		codeToTest = new Code(start);

		String expected = "[W, B, B, B, W, B, B, B]";
		String actual = codeToTest.toString();

		assertEquals(actual, expected);


	}

	@Test
	void testeConstrutor7() {

		ArrayList<BinaryColour> start = new ArrayList<BinaryColour>();

		start.add(BinaryColour.WHITE);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		

		codeToTest = new Code(start);

		int expected = 4;
		int actual = codeToTest.getLength();

		assertEquals(actual, expected);


	}
	
	@Test
	void testeConstrutor8() {

		ArrayList<BinaryColour> start = new ArrayList<BinaryColour>();

		start.add(BinaryColour.WHITE);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.BLACK);

		codeToTest = new Code(start);

		int expected = 7;
		int actual = codeToTest.getLength();

		assertEquals(actual, expected);


	}
	
	
	@Test
	void testeConstrutor9() {

		ArrayList<MultiColour> start = new ArrayList<MultiColour>();

		start.add(MultiColour.GREEN);
		start.add(MultiColour.BLUE);
		start.add(MultiColour.BLUE);
		start.add(MultiColour.BLUE);

		codeToTest = new Code(start);
		
		start.remove(0);

		String expected = "[G, B, B, B]";
		String actual = codeToTest.toString();

		assertEquals(actual, expected);


	}
	

}
