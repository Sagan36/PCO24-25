package types;

/**
 * An interface defining a contract for color-related entities.
 * This interface requires implementing classes to provide 
 * a method that returns all possible color values.
 * 
 * @author PCO team
 */
public interface Colour {

    /**
     * Retrieves all possible color values represented by 
     * the implementing class.
     * 
     * @return An array of Colour objects representing all possible colors.
     */
    Colour[] colours();
}