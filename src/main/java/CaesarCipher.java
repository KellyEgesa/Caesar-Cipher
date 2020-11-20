public class CaesarCipher {
    private String userInput;
    private int shiftKey;

    public CaesarCipher(String input, int key) {
        userInput = input;
        shiftKey = key;
    }

    public String getUserInput() {
        return userInput;
    }

    public int getShiftKey() {
        return shiftKey;
    }
}
