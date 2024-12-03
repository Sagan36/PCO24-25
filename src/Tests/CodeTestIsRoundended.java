package TestBullsAndCows;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import types.BinaryColour;
import types.BullsAndCows;
import types.Code;
import types.MastermindGame;

class CodeTestIsRoundended {

	public static String EOL = System.lineSeparator();

	private BullsAndCows jogo;

	@Test
	void teste1() {

		BinaryColour[] binario = BinaryColour.values();

		this.jogo = new BullsAndCows(0, 6, binario);

		boolean expected = false;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);


	}


	@Test
	void teste2() {

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

		boolean expected = false;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);
	}
	
	

	@Test
	void teste3() {

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

		boolean expected = false;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);
	}

	@Test
	void teste4() {

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

		boolean expected = false;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);;
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

		boolean expected = true;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);
	}
	
	@Test
	void teste6() {

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
		
		for (int i = 1; i < MastermindGame.MAX_TRIALS; i++) {
			jogo.play(tentativa);
		}
		

		boolean expected = false;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);
	}
	
	@Test
	void teste7() {

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
		
		for (int i = 0; i <= MastermindGame.MAX_TRIALS; i++) {
			jogo.play(tentativa);
		}
		

		boolean expected = true;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);
	}
}



