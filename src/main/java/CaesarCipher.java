public class CaesarCipher {
    private String userInput;
    private int shiftKey;

    public CaesarCipher(String input, int key) throws Exception {
        checkForNumber(input);
        userInput = input;

        shiftKey = key;
    }

    public String getUserInput() {
        return userInput;
    }

    public int getShiftKey() {
        return shiftKey;
    }

    private void checkForNumber(String numberToCheck) throws Exception {
        char[] checkNumbers = numberToCheck.toCharArray();
        for (char checkNumber : checkNumbers) {
            if (Character.isDigit(checkNumber)) {
                throw new Exception("The input contains a number");
            }
        }
    }

}
