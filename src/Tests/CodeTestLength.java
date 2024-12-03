package TestCode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import types.BinaryColour;
import types.Code;
import types.MultiColour;

class CodeTestLength {

	private Code codeToTest;

	@Test
	void teste1() {

		ArrayList<MultiColour> start = new ArrayList<MultiColour>();

		start.add(MultiColour.BLUE);
		start.add(MultiColour.GREEN);
		start.add(MultiColour.BLUE);
		
		codeToTest = new Code(start);

		int expected = 3;
		int actual = codeToTest.getLength();

		assertEquals(actual, expected);


	}
	
	@Test
	void teste2() {

		ArrayList<MultiColour> start = new ArrayList<MultiColour>();

		start.add(MultiColour.BLUE);
		
		codeToTest = new Code(start);

		int expected = 1;
		int actual = codeToTest.getLength();

		assertEquals(actual, expected);


	}
	
	@Test
	void teste3() {

		ArrayList<MultiColour> start = new ArrayList<MultiColour>();

		
		codeToTest = new Code(start);

		int expected = 0;
		int actual = codeToTest.getLength();

		assertEquals(actual, expected);


	}
	
	@Test
	public void teste4() {
		
		assertThrows(
					NullPointerException.class,
						() -> codeToTest.getLength(),
						"Expected top() to throw, but it didn't"
		);
	}

	
	@Test
	void teste5() {

		ArrayList<BinaryColour> start = new ArrayList<BinaryColour>();

		start.add(BinaryColour.WHITE);
		start.add(BinaryColour.BLACK);
		start.add(BinaryColour.WHITE);
		
		codeToTest = new Code(start);

		int expected = 3;
		int actual = codeToTest.getLength();

		assertEquals(actual, expected);


	}
	
	@Test
	void teste6() {

		ArrayList<BinaryColour> start = new ArrayList<BinaryColour>();

		start.add(BinaryColour.WHITE);
		
		codeToTest = new Code(start);

		int expected = 1;
		int actual = codeToTest.getLength();

		assertEquals(actual, expected);


	}
	
	

}
