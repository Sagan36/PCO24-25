package types;
	/**
	 * The MultiColourMastermindGame class is an implementation of the AbstractMastermindGame
	 * designed for a multi-colour version of the Mastermind game, where multiple colours are available
	 * for guessing and the score depends on the number of trials and hints used.
	 */
public class MultiColourMastermindGame extends AbstractMastermindGame {
	// The number of hints used in the game.
	private int hintsUsed;

    /**
     * Constructs a new MultiColourMastermindGame with the specified seed, code size, and available colours.
     *
     * @param seed    The seed used for random code generation.
     * @param size    The size of the secret code.
     * @param colours The array of available colours for the code.
     */
    public MultiColourMastermindGame (int seed, int size, Colour[] colours) {
        super(seed, size, colours);
        this.hintsUsed = 0;
    }
    
    /**
     * Returns the current score of the game.
     *
     * @return The current score of the game.
     */
    @Override
    public int score() {
    	return this.score;
    }
    
    /**
     * Updates the score based on the number of trials used and the number of hints used.
     * The score is calculated by rewarding fewer points for more trials, and the score
     * is further reduced based on the number of hints used.
     *
     * @return true if the score was updated successfully.
     */
    @Override
    public boolean updateScore() {
    	
    	int points;
    	
        if (getNumberOfTrials() <= 2) {
            points = 100;
        } else if (getNumberOfTrials() <= 5) {
            points = 50;
        } else {
            points = 20;
        }

        this.score += points / (this.hintsUsed + 1);
        return true;
    }
    
    /**
     * Checks if the current round is finished. A round is considered finished when the secret code
     * is revealed or the maximum number of trials has been reached.
     *
     * @return true if the round is finished, false otherwise.
     */
    @Override
    public boolean isRoundFinished() {
    	
        return wasSecretRevealed() || this.numberoftrials >= MAX_TRIALS;
    }
   @Override
   
   /**
    * Provides a hint to the player by revealing one of the colours in the secret code.
    * The number of hints used is incremented each time this method is called.
    *
    * @return A {@link Colour} that is part of the secret code.
    */
   public Colour hint() {
	   this.hintsUsed++;
	   return super.hint();
   }

}
