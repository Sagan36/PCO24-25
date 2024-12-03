package types;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/**
 * Abstract class representing the core logic for a Mastermind game.
 */

public abstract class AbstractMastermindGame implements MastermindGame {
    protected int seed;  //Seed for making the secretcode
    protected int size; // Size of the secret code
    protected Colour[] colours; // Array of available colours
    protected Random random; // Random generator for secret code and hints
    protected List<Attemps> trials;  // List of all attempts
    protected int score;   //Score of the round 
    protected Code secret; //The current secret code
    protected int numberoftrials; //Number of trials that were on this round
    
    /**
     * Represents an attempt in the Mastermind game, storing the code guess 
     * and the evaluation results of the guess.
     */
    static class Attemps{
    	Code code;
    	int PosiçãoCorreta;
    	int CoresCorretasPosicaoErrada;
    /**
     * Constructs an Attemps object with the given code and evaluation results.
     *
     * @param x The guessed code for this attempt.
     * @param a The number of colors in the correct position.
     * @param b The number of correct colors in the wrong position.
     */
    private Attemps(Code x, int a, int b){
    	this.code = x;
    	this.PosiçãoCorreta = a;
    	this.CoresCorretasPosicaoErrada = b;
    }
    /**
     * Compares this Attemps object to another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if both objects are of the same class, and their code, 
     *         PosiçãoCorreta, and CoresCorretasPosicaoErrada are equal; false otherwise.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; 
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; 
        }
        Attemps other = (Attemps) obj;
        return code.equals(other.code) && 
               PosiçãoCorreta == other.PosiçãoCorreta &&
               CoresCorretasPosicaoErrada == other.CoresCorretasPosicaoErrada;
    }

}
    /**
     * Constructor initializing the game with a random generator, size, and available colors.
     *
     * @param seed    the random generator seed for reproducibility.
     * @param size    the size of the secret code.
     * @param colours the array of available colors for the game.
     */
    public AbstractMastermindGame(int seed, int size, Colour[] colours) {
        this.seed = seed;
        this.size = size;
        this.colours = colours;
        this.random = new Random(seed);
        this.trials = new ArrayList<Attemps>();
        this.score = 0;
        this.numberoftrials = 0;
        startNewRound(); //Initializes the first round on the constructor
    }
	/**
	 * Processes a player's code attempt and evaluates it against the secret code.
	 *
	 * @param attempt the code attempt provided by the player.
	 */
  @Override  
  public void play(Code x) {

	if(isRoundFinished()) {
		System.out.println("Round is finished.");
		return;
	}
	
	int[] correct = secret.howManyCorrect(x);
	
	Attemps currentattempt = new Attemps(x, correct[0], correct[1]);
	
	this.numberoftrials++;
	
	if(!trials.contains(currentattempt)) {
		trials.add(currentattempt);
	}else {
		return;
	}
	
	
    if (correct[0] == size) { 
        System.out.println("Congratulations! You have guessed the secret code!");
        updateScore();
    }

    
}
  
  /**
   * Starts a new round by generating a new secret code and resetting trials.
  */
  @Override
  public void startNewRound() {
	 this.trials.clear();
	 this.numberoftrials = 0;
	 //makes the secret depending on which enum of the interface colour is selected
     if(colours[0] instanceof BinaryColour) {
         List<BinaryColour> secretColours = new ArrayList<>();
         for (int i = 0; i < size; i++) {
        	 BinaryColour bcolour = BinaryColour.values()[random.nextInt(colours.length)];
             secretColours.add(bcolour);
         }
         this.secret = new BullsAndCowsCode(secretColours);
     }else {
             List<Colour> secretColours = new ArrayList<>();
             for (int i = 0; i < size; i++) {
                 secretColours.add(colours[random.nextInt(colours.length)]);
             }
       	  this.secret = new Code(secretColours);
         }
      	    
}
  /**
   * Provides a hint by revealing a random color from the secret code.
   *
   * @return a color present in the secret code.
   */
  @Override
  public Colour hint() {
	  
      return secret.getCode().get(random.nextInt(secret.getLength()));
  }
  
  /**
   * Retrieves the best trial based on the number of correct guesses.
   *
   * @return the best code attempt.
   */
  @Override
  public Code bestTrial() {
	  //prevents if trials are empty
	  if (trials.isEmpty()) {
		  return null;
	  }
	  
	  Attemps best = this.trials.get(0);
	  //iterates over every registered attempt
	  for(Attemps trial: this.trials) {
		  if(trial.PosiçãoCorreta > best.PosiçãoCorreta) {
			  best = trial;
		  }else if(trial.PosiçãoCorreta == best.PosiçãoCorreta){
			  if(trial.CoresCorretasPosicaoErrada > best.CoresCorretasPosicaoErrada) {
				  best = trial;
			  }else if(trial.CoresCorretasPosicaoErrada == best.CoresCorretasPosicaoErrada) {
				  if(trial.code.toString().compareTo(best.code.toString()) < 0) {
					  best = trial;
				  }
			  }
		  }
	  }
	  
	  return best.code;
  }
  
  
  /**
   * Returns the number of trials attempted in the current round.
   *
   * @return the total number of trials.
   */
  @Override
  public int getNumberOfTrials() {  
	  return this.numberoftrials;
  }
  
  /**
   * Checks if the secret code has been revealed.
   *
   * @return true if the last attempt has all the colors in the correct positions, false otherwise.
   * If there are no attempts, returns false.
   */
  @Override
  public boolean wasSecretRevealed() {
	  //This is here so that when it runs without attemps it doesnt break.
      if (trials.isEmpty()) {
          return false; 
      }
      Attemps lastAttempt = trials.get(trials.size() - 1); 
      return lastAttempt.PosiçãoCorreta == size; 
  }
  
  
  
  /**
   * Provides a textual representation of the current game state.
   *
   * @return a string describing the game board, score, and attempts.
   */
  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      // Number of Trials
      sb.append("Number of Trials = ").append(getNumberOfTrials()).append("\n");

      // Score
      sb.append("Score = ").append(score).append("\n");
      // Secret Code: Masked if round is not finished, revealed otherwise
      if (isRoundFinished()) {
          sb.append(secret.toString()).append("\n");
      } else {
          sb.append("[");
          for (int i = 0; i < size; i++) {
              sb.append("?");
              if (i < size - 1) {
                  sb.append(", ");
              }
          }
          sb.append("]").append("\n");
      }
      sb.append("\n");

      // Trials
      int start = Math.max(0, trials.size() - 10); // Show the last 10 trials
      for (int i = start; i < trials.size(); i++) {
          Attemps trial = trials.get(i);
          sb.append(trial.code.toString())
            .append("    ")
            .append(trial.PosiçãoCorreta)
            .append(" ")
            .append(trial.CoresCorretasPosicaoErrada)
            .append("\n");
      }
      return sb.toString();
  }


    public abstract boolean isRoundFinished();
    public abstract int score();
    public abstract boolean updateScore();
}

