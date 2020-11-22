public class Encrypt {
    private String userInput;
    private int shiftKey;
    private final String alphabets = "abcdefghijklmnopqrstuvwxyz";

    public Encrypt(String input, int key) throws Exception {
        if (!input.isEmpty()) {
            checkForNumber(input);
            userInput = input;
            if(key > 26){
                shiftKey = key % 26;
            }
            else{
                shiftKey = key;
            }
        } else {
            throw new Exception("The input is null");
        }

    }

    public String getUserInput() {
        return userInput;
    }

    public int getShiftKey() {
        return shiftKey;
    }

    public String encrypt() {
        String[] toEncryptAlphabets = userInput.split("");
        String encrypted = "";
        for (String toEncryptAlphabet : toEncryptAlphabets) {
            Boolean upperCase = Character.isUpperCase(toEncryptAlphabet.charAt(0));
            String alphabetRef;
            if(upperCase){
                alphabetRef = alphabets.toUpperCase();
            }
            else{
                alphabetRef = alphabets;
            }
            if (alphabetRef.contains(toEncryptAlphabet)) {
                int indexOfAlphabet = alphabetRef.indexOf(toEncryptAlphabet);
                int indexOfEncryptedAlphabet = indexOfAlphabet + shiftKey;
                if (indexOfEncryptedAlphabet > 25) {
                    encrypted +=  alphabetRef.charAt(indexOfEncryptedAlphabet - 26);;
                } else {
                    encrypted += alphabetRef.charAt(indexOfEncryptedAlphabet);
                }
            } else {
                encrypted += toEncryptAlphabet;
            }
        }
        return encrypted;
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
