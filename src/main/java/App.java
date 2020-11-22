import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("===========================================================================");
        System.out.println("===============================CAESAR CIPHER===============================");
        System.out.println("==================================WELCOME==================================");

        System.out.println("Kindly enter your String below:-");
        String userInput = myScanner.nextLine();
        System.out.println(userInput);
        System.out.println("Enter the ShiftKey below:-");
        int shiftKey = myScanner.nextInt();

        Encrypt encrypted = new Encrypt(userInput, shiftKey);

        System.out.println("===========================================================================");
        System.out.println("===========================================================================");

        System.out.println("Input String: "+userInput);
        System.out.println("Encrypted String: "+encrypted.encrypt());
        System.out.println("Decrypted String: "+new Decrypt(encrypted.encrypt(), encrypted.getShiftKey()).decrypt());
        


    }
}
