package TestCode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import types.BinaryColour;
import types.Code;
import types.Colour;
import types.MultiColour;

class CodeTestgetCode {

	private Code codeToTest;

	@Test
	void teste1() {

		ArrayList<MultiColour> expected = new ArrayList<MultiColour>();

		expected.add(MultiColour.BLUE);
		expected.add(MultiColour.BLUE);
		expected.add(MultiColour.BLUE);
		expected.add(MultiColour.BLUE);

		codeToTest = new Code(expected);

		List<Colour> actual = codeToTest.getCode();

		assertEquals(actual, expected);


	}
	
	@Test
	void teste2() {

		ArrayList<MultiColour> expected = new ArrayList<MultiColour>();

		expected.add(MultiColour.BLUE);
		expected.add(MultiColour.ORANGE);
		expected.add(MultiColour.BLUE);
		expected.add(MultiColour.GREEN);
		expected.add(MultiColour.BLUE);
		expected.add(MultiColour.ORANGE);
		expected.add(MultiColour.BLUE);
		expected.add(MultiColour.GREEN);

		codeToTest = new Code(expected);

		List<Colour> actual = codeToTest.getCode();

		assertEquals(actual, expected);


	}
	
	@Test
	void teste3() {

		ArrayList<BinaryColour> expected = new ArrayList<BinaryColour>();

		expected.add(BinaryColour.WHITE);
		expected.add(BinaryColour.WHITE);
		expected.add(BinaryColour.WHITE);
		expected.add(BinaryColour.WHITE);

		codeToTest = new Code(expected);

		List<Colour> actual = codeToTest.getCode();

		assertEquals(actual, expected);


	}
	
	@Test
	void teste4() {

		ArrayList<BinaryColour> expected = new ArrayList<BinaryColour>();

		expected.add(BinaryColour.WHITE);
		expected.add(BinaryColour.WHITE);
		expected.add(BinaryColour.WHITE);
		expected.add(BinaryColour.WHITE);
		expected.add(BinaryColour.BLACK);
		expected.add(BinaryColour.WHITE);
		expected.add(BinaryColour.BLACK);
		expected.add(BinaryColour.WHITE);

		codeToTest = new Code(expected);

		
		List<Colour> actual = codeToTest.getCode();

		assertEquals(actual, expected);


	}
	
	
}
