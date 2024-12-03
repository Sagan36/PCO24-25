package TestBullsAndCows;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import types.BinaryColour;
import types.BullsAndCows;
import types.Code;

class CodeTestBestTrial {

	public static String EOL = System.lineSeparator();

	private BullsAndCows jogo;

	@Test
	void teste1() {

		BinaryColour[] binario = BinaryColour.values();

		this.jogo = new BullsAndCows(0, 6, binario);

		Code expected = null;

		Code actual = jogo.bestTrial();

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

		Code expected = tentativa;

		Code actual = jogo.bestTrial();

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
		
		Code expected = tentativa;
		
		jogo.play(tentativa);
		jogo.play(tentativa);

		trial.removeLast();
		trial.add(BinaryColour.WHITE);

		tentativa = new Code(trial);

		jogo.play(tentativa);

		Code actual = jogo.bestTrial();
		
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

		
		Code expected = tentativa;

		Code actual = jogo.bestTrial();

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
				
		jogo.play(tentativa);
		
		
		
		trial.clear();
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.WHITE);

		tentativa = new Code(trial);

		jogo.play(tentativa);

		Code expected = tentativa;
		
		Code actual = jogo.bestTrial();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void teste7() {

		BinaryColour[] binario = BinaryColour.values();

		this.jogo = new BullsAndCows(0, 6, binario);

		ArrayList<BinaryColour> trial = new ArrayList<BinaryColour>();

		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.WHITE);

		Code tentativa = new Code(trial);
				
		jogo.play(tentativa);
		
		Code expected = tentativa;
		
		trial.clear();
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.WHITE);

		tentativa = new Code(trial);

		jogo.play(tentativa);

		
		Code actual = jogo.bestTrial();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void teste8() {

		BinaryColour[] binario = BinaryColour.values();

		this.jogo = new BullsAndCows(1, 6, binario);

		ArrayList<BinaryColour> trial = new ArrayList<BinaryColour>();

		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);

		Code tentativa = new Code(trial);
				
		jogo.play(tentativa);
		
		
		trial.clear();
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.WHITE);
		trial.add(BinaryColour.BLACK);
		trial.add(BinaryColour.BLACK);

		tentativa = new Code(trial);

		jogo.play(tentativa);

		Code expected = tentativa;
		
		System.out.println(jogo);
		
		Code actual = jogo.bestTrial();
		
		assertEquals(expected, actual);
	}
}



