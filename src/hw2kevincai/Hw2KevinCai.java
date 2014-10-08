/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2kevincai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Kevin
 */
public class Hw2KevinCai {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        //Define some variables to use in program
        Scanner console = new Scanner(System.in);
        String read = "", strToWrite = "";
        //Variable to end the game
        int number, error = 0, result, stop;
        //this will store the current guess
        String guess = "-1";
        //this will keep track of number of guesses
        int guessInt = -1;
        int numGuess = 0;
        //this will count the number of games played successfully
        int numGamesWon = 0;
        //this will count the number of games quit
        int numGamesQuit = 0;
        Random secretNumberGenerator = new Random();
        int secretNumber = secretNumberGenerator.nextInt(100) + 1;

        /* int answer1 = 0;
         String playAgain = Integer.toString(answer1);
         playAgain="Y";
         */
        int value = -1;
        boolean valid = false;
        String input = "Y";

        //to capture user's input
        String gamerName = "";

        StringBuilder stringToSave = new StringBuilder("");
        //Print welcome screen
        System.out.println("Welcome to the Guessing Game.  "
                + "To start playing, please enter your username:");
        gamerName = console.nextLine();
        //Print Game instructions
        System.out.println("\n" + "Hi " + gamerName + "," + " Welcome to the Game! \n"
                + "The system will randomly select a number between 1 and 100. "
                + "Your goal is to guess the number. \n"
                + "At each turn enter in your guess, and you will be informed if "
                + "your guess is high or low " + "\n");

        System.out.println("Secret number is " + secretNumber);
        //Ask user for input and place in do while to ensure games does not prematurely end if User enters in a value other than specified
        

        do {
            try {
                System.out.println("Your guess from 1-100 (enter N to stop):");
                guess = console.next();

                System.out.println("Your guess from 1 - 100 is? (enter N/0 to stop) ");

                if (guess.equals("N")) {

                    System.out.println("Thanks for playing ");
                    System.exit(0);
                }

                if (!guess.equals("Y")) {
                    guessInt = Integer.valueOf(guess);
                }
                else{
                System.out.println("Your guess from 1-100:");    
                guessInt = console.nextInt();
                
                }
                if (guessInt == 0) {
                    numGamesQuit = numGamesQuit + 1;
                    System.out.println("Quit");
                } else if (secretNumber < guessInt) {
                    numGuess = numGuess + 1;
                    System.out.println("High. Try again");
                } else if (secretNumber > guessInt) {
                    numGuess = numGuess + 1;
                    System.out.println("Low. Try again");
                } else if (secretNumber == guessInt) {
                    numGuess = numGuess + 1;
                    numGamesWon = numGamesWon + 1;
                    System.out.println("\n" + "Perfect. You guessed correct in " + numGuess + " attempts. "
                            + "Would you like to play again (Y/N)?");

                }

            } catch (InputMismatchException ime) {

                error = -1;
                System.err.println("You did not enter a number.");
                console.nextLine();
            }
        } while (guessInt != 0);
        System.out.println("\n" + gamerName + " Your Stats:");
        System.out.println("Number of Guesses " + numGuess);
        System.out.println("Number of games won " + numGamesWon);
        System.out.println("Number of games quit " + numGamesQuit + "\n");

        System.out.println("Username\t\t Played\t\t Won\t\t Quit\t\t");
        stringToSave.append(gamerName).append("\t\t").append(numGuess)
                .append("\t\t").append(numGamesWon).append("\n");
        strToWrite = stringToSave.toString();
        System.out.println("" + strToWrite);
        
        //created an int variable to reference a method that is defined below
        int writeStatus = writeScoresToFile(strToWrite);
        //this is to show user that the output to file was successful
        System.out.println("The write status is: " + writeStatus);

        BufferedReader inputBuff = new BufferedReader(new FileReader("gamescores.txt"));

        try{
     read = stringToSave.toString();
        System.out.println(""+read);
    int readStatus = readScoresFromFile(read);
        System.out.println("The read status is: " + readStatus);
    }
    catch (IOException ioe) {
            System.err.println("There was an error writing to the file: " 
                    + ioe.toString());
        }
    }

    

    private static int writeScoresToFile(String string2) {

        int success = 0;
        BufferedWriter outputBuff = null;

        try {
            outputBuff = new BufferedWriter(
                    new FileWriter("gamescores.txt", true));
            outputBuff.write(string2);
            outputBuff.flush();
        } catch (IOException ioe) {
            System.err.println("There was an error writing to the file: "
                    + ioe.toString());
        }

        // methods that have non-void return type should end with a return command
        // followed by the name of the variable or a literal value that matches the 
        // return data type
        // return true; would be correct or
        // return answer;
        return success;
    }
    private static int readScoresFromFile (String string3) throws FileNotFoundException, IOException {
    
        
        int answer2= 1;
    String read = "gamescores.txt";
   try{
    FileReader inputFile = new FileReader (read);
            try (BufferedReader inputBuff = new BufferedReader (inputFile)) {
                String read1;
                
                while ((read1 = inputBuff.readLine()) != null) {
                    System.out.println("The read status is:" + read);
                }   }
    }catch(Exception error){
            System.out.println("Error while reading file line by line:" 
            + error.getMessage());                      
    

}
return answer2;
}
}