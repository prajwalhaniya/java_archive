public class Alphabet {
    
	public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String NUMBERS = "1234567890";
	public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";


    private final StringBuilder pool;

    public Alphabet(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
        
        pool = new StringBuilder();

        if (IncludeUpper) {
            pool.append(UPPERCASE_LETTERS);
        }

        if (IncludeLower) {
            pool.append(LOWERCASE_LETTERS);
        }

        if (IncludeNum) {
            pool.append(NUMBERS);
        }

        if (IncludeSym) {
            pool.append(SYMBOLS);
        }
    }

    public String getAlphabet() {
        return pool.toString();
    }

}
