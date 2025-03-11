package simple_startup.src;
import java.util.Scanner;

public class GameHelper {
    public int getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        
        int userInput = scanner.nextInt();
        return userInput;
    }
}
