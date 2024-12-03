package types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class representing a code for the Bulls and Cows variant of the Mastermind game.
 * This class extends Code and implements specific logic for calculating
 * the number of bulls (correct colors in the correct position) and cows (correct colors in the wrong position).
 */
public class BullsAndCowsCode extends Code {

    /**
     * Constructs a BullsAndCowsCode instance with the given sequence of binary colors.
     * 
     * @param code A list of binary colors representing the secret code.
     */
    public BullsAndCowsCode(List<BinaryColour> code) {
        super(code);
    }

    /**
     * Calculates the number of bulls (correct colors in the correct position)
     * and cows (correct colors in the wrong position) for a given attempt.
     * 
     * @param other The code attempted by the player.
     * @return An array of two integers:
     *         - The first element is the number of bulls.
     *         - The second element is the number of cows.
     */
    @Override
    public int[] howManyCorrect(Code other) {
        // Retrieve the secret code and the attempt code
        List<Colour> secretCode = this.getCode();
        List<Colour> attemptCode = other.getCode();

        int bulls = 0;  // Correct colors in correct positions
        int cows = 0;   // Correct colors in wrong positions

        // Maps to count the frequency of each color in incorrect positions
        Map<Colour, Integer> secretColourCounts = new HashMap<>();
        Map<Colour, Integer> attemptColourCounts = new HashMap<>();

       
        for (int i = 0; i < secretCode.size(); i++) {
            Colour secretColour = secretCode.get(i);
            Colour attemptColour = attemptCode.get(i);

            if (secretColour.equals(attemptColour)) {
                bulls++; // Correct position and color
            } else {
                // Track mismatched colors
                secretColourCounts.put(secretColour, secretColourCounts.getOrDefault(secretColour, 0) + 1);
                attemptColourCounts.put(attemptColour, attemptColourCounts.getOrDefault(attemptColour, 0) + 1);
            }
        }

  
        for (Map.Entry<Colour, Integer> entry : attemptColourCounts.entrySet()) {
            Colour colour = entry.getKey();
            int attemptCount = entry.getValue();
            int secretCount = secretColourCounts.getOrDefault(colour, 0);

            // Add the minimum count of the color between the two lists
            cows += Math.min(attemptCount, secretCount);
        }

        return new int[]{bulls, cows};
    }
}
