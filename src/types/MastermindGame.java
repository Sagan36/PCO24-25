package types;


/**
 * Interface representing a Mastermind game.
 */
public interface MastermindGame {
    int MAX_TRIALS = 25;

    /**
     * Plays a new attempt in the current round.
     *
     * @param attempt the code attempt to evaluate.
     */
    void play(Code attempt);
    
    /**
     * Checks if the current round is finished.
     *
     * @return true if the round is finished, false otherwise.
     */
    boolean isRoundFinished();

    /**
     * Starts a new round by resetting game state and generating a new secret code.
     */
    void startNewRound();
    
    /**
     * Provides a hint, revealing one color in the secret code.
     *
     * @return a color that is part of the secret code.
     */
    Colour hint();

    /**
     * Gets the number of trials performed in the current round.
     *
     * @return the number of trials.
     */
    int getNumberOfTrials();
    
    /**
     * Returns the best trial (the one with the highest number of correct guesses).
     *
     * @return the best trial code.
     */
    Code bestTrial();
    
    /**
     * Gets the current score.
     *
     * @return the current game score.
     */
    int score();
    
    /**
     * Checks if the secret code has been revealed in the current round.
     *
     * @return true if the secret code was revealed, false otherwise.
     */
    boolean wasSecretRevealed();
}
