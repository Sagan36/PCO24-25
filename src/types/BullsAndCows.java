package types;

	/**
	 * The BullsAndCows class is a specific implementation of the AbstractMastermindGame 
	 * designed for the binary-colour version of the Mastermind game.
	 */
public class BullsAndCows extends AbstractMastermindGame {

    /**
     * Constructs a new BullsAndCows game with the specified seed, code size, and available colours.
     *
     * @param seed    The seed used for random code generation.
     * @param size    The size of the secret code.
     * @param colours The array of available colours for the code.
     */
    public BullsAndCows(int seed, int size, Colour[] colours) {
        super(seed, size, colours);
        
    }
    /**
     * Returns the current score of the game.
     *
     * @return The score of the game.
     */
    @Override
    public int score() {
    	return this.score;
    }
    
    /**
     * Updates the score by adding a fixed value of 2000 points. 
     * This is typically called after a successful action, such as a correct guess.
     *
     * @return true to indicate the score was updated successfully.
     */
    @Override
    public boolean updateScore() {
    	this.score += 2000;    	
    return true;
    }
    
    /**
     * Checks if the current round is finished. A round ends either when the secret code 
     * has been revealed or when the maximum number of trials is reached.
     *
     * @return true if the round is finished, false otherwise.
     */
    @Override
    public boolean isRoundFinished() {
    	
        return wasSecretRevealed() || this.numberoftrials >= MAX_TRIALS;
    }
    /**
     * Provides a hint to the player by revealing one of the colours in the secret code.
     * When this method is called, the score is halved as a penalty for requesting a hint.
     *
     * @return A Colour that is part of the secret code.
     */
    @Override
    public Colour hint() {
    	this.score /= 2;
    	
    	return super.hint();
    }
}