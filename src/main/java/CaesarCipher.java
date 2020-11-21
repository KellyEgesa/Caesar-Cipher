public class CaesarCipher {
    private String userInput;
    private int shiftKey;
    private final String alphabets = "abcdefghijklmnopqrstuvwxyz";


    public CaesarCipher(String input, int key) throws Exception {
        if (input != "") {
            checkForNumber(input);
            userInput = input;
            shiftKey = key;
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
        String[] alphabetsArrays = alphabets.split("");
        String[] toEncryptAlphabets = userInput.split("");
        String encrypted = "";
        for (String toEncryptAlphabet : toEncryptAlphabets) {
            if (alphabets.contains(toEncryptAlphabet)) {
                int indexOfAlphabet = alphabets.indexOf(toEncryptAlphabet);
                int indexOfEncryptedAlphabet = indexOfAlphabet + shiftKey;
                if (indexOfEncryptedAlphabet > 25) {
                    encrypted += alphabetsArrays[indexOfEncryptedAlphabet - 26];
                } else {
                    encrypted += alphabetsArrays[indexOfEncryptedAlphabet];
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

    public String decrypt() {
        String[] alphabetsArrays = alphabets.split("");
        String[] toDecryptAlphabets = userInput.split("");
        String decrypted = "";
        for (String toDecryptAlphabet: toDecryptAlphabets) {
            int indexOfAlphabet = alphabets.indexOf(toDecryptAlphabet);
            int indexOfDecryptedAlphabet = indexOfAlphabet - shiftKey;
            if(indexOfDecryptedAlphabet < 0){
                decrypted += alphabetsArrays[26 + indexOfDecryptedAlphabet];
            }
            else{
                decrypted += alphabetsArrays[indexOfDecryptedAlphabet];
            }
        }
        return  decrypted;
    }
}
