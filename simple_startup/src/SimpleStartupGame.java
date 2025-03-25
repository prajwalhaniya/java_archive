package simple_startup.src;
import java.util.ArrayList;
import java.util.Arrays;


public class SimpleStartupGame {
    public static void main(String[] args) {
        int numOfGuesses = 0;

        GameHelper helper = new GameHelper();
        
        Startup theStartup = new Startup();

        ArrayList<String> locations = new ArrayList<>(Arrays.asList("A1", "A2", "A3", "A4", "A5"));
        theStartup.setLocationCells(locations);
        
        boolean isAlive = true;

        while (isAlive) {
            String guess = helper.getUserInput("Enter a string");
            String result = theStartup.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
        }
    }
}
