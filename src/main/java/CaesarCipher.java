public class CaesarCipher {
    private String userInput;
    private int shiftKey;
    private final String alphabets = "abcdefghijklmnopqrstuvwxyz";


    public CaesarCipher(String input, int key) throws Exception {
        if (input != "") {
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

    public String decrypt() {
        String[] toDecryptAlphabets = userInput.split("");
        String decrypted = "";
        for (String toDecryptAlphabet: toDecryptAlphabets) {
            Boolean upperCase = Character.isUpperCase(toDecryptAlphabet.charAt(0));
            String alphabetRef;
            if(upperCase){
                alphabetRef = alphabets.toUpperCase();
            }
            else{
                alphabetRef = alphabets;
            }
            if (alphabetRef.contains(toDecryptAlphabet)){
                int indexOfAlphabet = alphabetRef.indexOf(toDecryptAlphabet);
                int indexOfDecryptedAlphabet = indexOfAlphabet - shiftKey;
                if(indexOfDecryptedAlphabet < 0){
                    decrypted += alphabetRef.charAt(26 + indexOfDecryptedAlphabet);
                }
                else{
                    decrypted += alphabetRef.charAt(indexOfDecryptedAlphabet);
                }
            }else{
                decrypted+=toDecryptAlphabet;
            }

        }
        return  decrypted;
    }
}
