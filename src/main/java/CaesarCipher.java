public class CaesarCipher {
    private String userInput;
    private int shiftKey;

    public CaesarCipher(String input, int key) throws Exception {
        char[] checkNumbers = input.toCharArray();
        Boolean numberFound = false;
        for (char checkNumber : checkNumbers) {
            if (Character.isDigit(checkNumber)) {
                numberFound = true;
            }
        }
        if (numberFound) {
            throw new Exception("The input contains a number");
        } else {
            userInput = input;
        }
        shiftKey = key;
    }

    public String getUserInput() {
        return userInput;
    }

    public int getShiftKey() {
        return shiftKey;
    }

    public Boolean check() {
        return Boolean.parseBoolean(getUserInput());
    }

}
