package TestBullsAndCows;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import types.BinaryColour;
import types.BullsAndCows;
import types.Code;
import types.Colour;

class CodeTestHint {

	public static String EOL = System.lineSeparator();

	private BullsAndCows jogo;

	@Test
	void teste1() {

		BinaryColour[] binario = BinaryColour.values();

		this.jogo = new BullsAndCows(0, 6, binario);

		Colour expected = BinaryColour.BLACK;
		Colour actual = jogo.hint();

		assertEquals(expected, actual);


	}
	
	
	@Test
	void teste2() {

		BinaryColour[] binario = BinaryColour.values();

		this.jogo = new BullsAndCows(2, 6, binario);

		Colour expected = BinaryColour.WHITE;
		Colour actual = jogo.hint();

		assertEquals(expected, actual);


	}
	
	@Test
	void teste3() {

		BinaryColour[] binario = BinaryColour.values();

		this.jogo = new BullsAndCows(2, 6, binario);

		jogo.hint();
		
		int expected = 0;
		int actual = jogo.score();

		assertEquals(expected, actual);


	}
	
	@Test
	void teste5() {

		BinaryColour[] binario = BinaryColour.values();

		this.jogo = new BullsAndCows(0, 6, binario);

		ArrayList<BinaryColour> trial = new ArrayList<BinaryColour>();

		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);

		Code tentativa = new Code(trial);
		jogo.play(tentativa);
		jogo.play(tentativa);

		trial.removeLast();
		trial.add(BinaryColour.WHITE);

		tentativa = new Code(trial);

		jogo.play(tentativa);

		trial.clear();
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.BLACK);

		tentativa = new Code(trial);

		jogo.play(tentativa);
		
		jogo.startNewRound();
		
		jogo.hint();

		int expected = 1000;

		int actual = jogo.score();

		assertEquals(expected, actual);
	}



}



