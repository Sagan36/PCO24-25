package Main;
import types.*;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Mastermind!");
        boolean keepPlaying = true;

        // Prompt the user to choose the game type
        System.out.println("Choose the game type:");
        System.out.println("1. MultiMastermind (Multi-colour Mastermind)");
        System.out.println("2. BullsAndCows (Binary-colour Mastermind)");
        
        int gameChoice = scanner.nextInt();
        scanner.nextLine(); 
        Random random = new Random();
        AbstractMastermindGame game;
        int codeSize = 4; 
        int seed = random.nextInt();  
        Colour[] colours;
        
        // Instantiate the chosen game type
        if (gameChoice == 1) {
            colours = MultiColour.values();
            game = new MultiColourMastermindGame(seed, codeSize, colours);
            StringBuilder sb = new StringBuilder();
            sb.append("In the MultiMasterMind game mode you will have to choose between 4 of this colours; ")
            .append("\n")
            .append("\n")
            .append("Blue as ").append(colours[0]).append(", ")
            .append("\n")
            .append("Red as ").append(colours[1]).append(", ")
            .append("\n")
            .append("Yellow as ").append(colours[2]).append(", ")
            .append("\n")
            .append("Green as ").append(colours[3]).append(", ")
            .append("\n")
            .append("Purple as ").append(colours[4]).append(", ")
            .append("\n")
            .append("Orange as ").append(colours[5]).append(".")
            .append("\n")
            .append("\n");
            sb.append("One thing to also take notice is that the more hints you use the less score you get.")
            .append("\n");
         
          System.out.println(sb);
        } else {
        	StringBuilder sb = new StringBuilder();
            colours = BinaryColour.values();
            game = new BullsAndCows(seed, codeSize, colours);
        	sb.append("In the Bulls and Cows game mode you will have to choose between 2 of this colours;")
            .append("\n")
            .append("\n")
            .append("Black as ").append(colours[0]).append(", ")
            .append("\n")

            .append("White as ").append(colours[1]).append(", ");
            
        	System.out.println(sb);
        }
        
        System.out.println("New game started!");
        System.out.println("Try to guess the secret code. Type 'hint' to get a hint.");

        // Main game loop
        while(keepPlaying) {
        while (!game.isRoundFinished()) {
            System.out.println("Enter your attempt (the colours must be seperated betweem comas, example: R,G,P,Y):");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("hint")) {
                Colour hint = game.hint();
                System.out.println("Hint: One of the colors in the code is " + hint);
                continue;
            }
            
            List<Colour> attempt = new ArrayList<>();
            
            String[] colorNames = input.split(",");
            if (colorNames.length != codeSize ) {
                System.out.println("The attempt must contain exactly " + codeSize + " colors. Please try again.");
                continue;
            }
            	boolean validInput = true;
                for (String colorName : input.split(",")) {
                    colorName = colorName.trim().toUpperCase(); 

                    // Check if the color exists in the enum values
                    boolean colorFound = false;
                    for (Colour c : colours) {
                        if (c.toString().equalsIgnoreCase(colorName)) {
                            attempt.add(c);
                            colorFound = true;
                            validInput = true;
                            break;
                        }
                    }

                    if (!colorFound) {
                    	System.out.println("Invalid color: " + colorName);
                        System.out.println("Use only the colours the game gave to you at the start.");
                        validInput = false;
                        break;
                    }
                }
         // If the input was invalid
            if (!validInput) {
                continue; 
            }
                
            // Perform the attempt
            game.play(new Code(attempt));

            
            // Display the current game status
            System.out.println(game);
        }


        // Round finished and asks the user if it wants to continue playing
        System.out.println("Round finished!");
        if (game.wasSecretRevealed()) {
            System.out.println("Congratulations! You discovered the secret code!");
            System.out.println("Current Score: " + game.score());
        } else {
            System.out.println("Unfortunately, you did not discover the secret code.");
        }
        System.out.println("You want to contine playing? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        if(!response.equals("y")) {
        	keepPlaying = false;
        	System.out.println("Thank you for playing!");
            System.out.println("Final Score: " + game.score());
            scanner.close();
        }else {
        	game.startNewRound();
        }
    }
        System.exit(0);
    }
    
}
