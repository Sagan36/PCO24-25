package types;

/**
 * An enumeration representing multiple colors with predefined color constants.
 * This enum provides a string representation for each color and 
 * implements the Colour interface,which requires a method to 
 * retrieve all color values.
 * 
 * @author PCO Team
 */
public enum MultiColour implements Colour {

    BLUE("B"),
    RED("R"),
    YELLOW("Y"),
    GREEN("G"),
    PINK("P"),
    ORANGE("O");

    // The string representation of the color.
    private String rep;

    /**
     * Constructor for the MultiColour enumeration.
     * 
     * @param s The string representation of the color.
     */
    MultiColour(String s) {
        this.rep = s;
    }

    /**
     * Returns the string representation of the color.
     * 
     * @return The string representation of the color.
     */
    @Override
    public String toString() {
        return this.rep;
    }

    /**
     * Returns an array containing all of the values of the MultiColour enum type.
     * 
     * @return An array of all enum constants in MultiColour, cast to the Colour type.
     */
    @Override
    public Colour[] colours() {
        return MultiColour.values();
    }
}