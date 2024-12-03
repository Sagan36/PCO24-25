package types;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a code consisting of a sequence of colors.
 */
public class Code implements Cloneable {
    private final List<Colour> code;

    /**
     * Constructor initializing a code with a given sequence of colors.
     *
     * @param code the sequence of colors for this code.
     */
    public Code(List<? extends Colour> code) {
        this.code = new ArrayList<>(code);
    }

    /**
     * Gets the sequence of colors in this code.
     *
     * @return a list of colors in the code.
     */
    public List<Colour> getCode() {
        return new ArrayList<>(code);
    }

    /**
     * Returns the length of the code.
     *
     * @return the size of the code.
     */
    public int getLength() {
        return code.size();
    }

    /**
     * Compares this code with another to calculate the number of bulls and cows.
     *
     * @param other the code to compare with.
     * @return an array where the first element is the number of bulls and the second is the number of cows.
     */
    public int[] howManyCorrect(Code other) {
        int correctPosition = 0;
        int correctColorWrongPosition = 0;
        List<Colour> otherCode = other.getCode();

        for (int i = 0; i < code.size(); i++) {
            if (code.get(i).equals(otherCode.get(i))) {
                correctPosition++;
            } else if (otherCode.contains(code.get(i))) {
                correctColorWrongPosition++;
            }
        }
        return new int[]{correctPosition, correctColorWrongPosition};
    }

    /**
     * Provides a textual representation of the code.
     *
     * @return a string representation of the code.
     */
    @Override
    public String toString() {
        return code.toString();
    }

    /**
     * Creates a clone of this code.
     *
     * @return a new Code object with the same sequence of colors.
     */
    @Override
    public Code clone() {
        return new Code(this.getCode());
    }

    /**
     * Checks if this code is equal to another object.
     *
     * @param obj the object to compare with.
     * @return true if the object is equal to this code, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Code)) return false;
        Code other = (Code) obj;
        return code.equals(other.code);
    }
}

