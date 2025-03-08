import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
    }

    public void mainLoop() {
        System.out.println("Welcome!!");
        printMenu();

        String userOption = "-1";

        while (!userOption.equals("4")) {

            userOption = keyboard.next();
            
            switch (userOption) {
                case "1" -> {
                    requestPassword();
                    printMenu();
                }

                case "2" -> {
                    checkPassword();
                    printMenu();
                }

                case "3" -> {
                    printUsefulInfo();
                    printMenu();
                }

                case "4" -> {
                    printQuitMessage();
                    printMenu();
                }

                default -> {
                    System.out.println();
                    System.out.println("Kindly select one of the available commands");
                    printMenu();
                }

            }
        }       
                
    }

    private void requestPassword() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum = false;
        boolean IncludeSym = false;

        boolean correctParams = false;

        System.out.println();
        System.out.println("Answer the following questions to generate a password");

        do {

            String input = keyboard.nextLine();

            System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
            input = keyboard.nextLine();

            if (isInclude(input)) IncludeLower = true;

            System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
            input = keyboard.nextLine();

            if (isInclude(input)) IncludeUpper = true;

            System.out.println("Do you want Numbers \"1234...\" to be used? ");
            input = keyboard.nextLine();

            if (isInclude(input)) IncludeNum = true;

            System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
            input = keyboard.nextLine();

            if (isInclude(input)) IncludeSym = true;

            //No Pool Selected
            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
                System.out.println("You have selected no characters to generate your " +
                        "password at least one of your answers should be Yes");
                correctParams = true;
            }

            System.out.println("Great! Now enter the length of the password");
            int length = keyboard.nextInt();

            final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
            final Password password = generator.GeneratePassword(length);

            System.err.println("Your generated password -> " + password);

        } while (correctParams);
        
    }

    private Password GeneratePassword(int length) {
        final StringBuilder pass = new StringBuilder("");
        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }

    private boolean isInclude(String input) {
        if (input.equalsIgnoreCase("yes")) {
            return true;
        } else {
            if (input.equalsIgnoreCase("no")) {
                PasswordRequestError();
            }
            return false;
        }
    }

    private void PasswordRequestError() {
        System.out.println("You have entered something incorrect let's go over it again \n");
    }

    private void checkPassword() {
        String input;
        final Scanner in = new Scanner(System.in);

        System.out.println("\n Enter your password");
        input = in.nextLine();

        final Password p = new Password(input);

        System.out.println(p.CalculateScore());
        System.out.println();
        in.close();
    }

    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }

    private void printQuitMessage() {
        System.out.println("Closing the program!");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1: Password generator");
        System.out.println("2: Password strength check");
        System.out.println("3: Useful information");
        System.out.println("4: Exit");
        System.out.println("Your choice: ");
    }


    
}