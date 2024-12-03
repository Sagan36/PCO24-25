package TestBullsAndCows;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import types.BinaryColour;
import types.BullsAndCows;
import types.Code;

class CodeTestToSTring {

	public static String EOL = System.lineSeparator();

	private BullsAndCows jogo;

	@Test
	void teste1() {

		BinaryColour[] binario = BinaryColour.values();

		this.jogo = new BullsAndCows(0, 6, binario);

		String expected = "Number of Trials = 0" + EOL
				+ "Score = 0" + EOL
				+ "[?, ?, ?, ?, ?, ?]" + EOL
				+ EOL;
		String actual = jogo.toString();

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

		String expected = "Number of Trials = 1" + EOL
				+ "Score = 0" + EOL
				+ "[?, ?, ?, ?, ?, ?]" + EOL
				+ "\n"
				+ "[B, B, B, B, B, B]    2 0" + EOL;
		String actual = jogo.toString();

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

		String expected = "Number of Trials = 2" + EOL
				+ "Score = 0" + EOL
				+ "[?, ?, ?, ?, ?, ?]" + EOL
				+ "\n"
				+ "[B, B, B, B, B, B]    2 0" + EOL;
		String actual = jogo.toString();

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

		String expected = "Number of Trials = 3" + EOL
				+ "Score = 0" + EOL
				+ "[?, ?, ?, ?, ?, ?]" + EOL
				+ "\n"
				+ "[B, B, B, B, B, B]    2 0" + EOL
				+ "[B, B, B, B, B, W]    1 2" + EOL;
		String actual = jogo.toString();

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

		String expected = "Number of Trials = 4" + EOL
				+ "Score = 2000" + EOL
				+ "[W, W, B, W, W, B]" + EOL
				+ "\n"
				+ "[B, B, B, B, B, B]    2 0" + EOL
				+ "[B, B, B, B, B, W]    1 2" + EOL
				+ "[W, W, B, W, W, B]    6 0" + EOL;
		String actual = jogo.toString();

		assertEquals(expected, actual);
	}
}



