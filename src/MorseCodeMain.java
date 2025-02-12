import java.util.Scanner;


public class MorseCodeMain {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Choose the operation: ");
        System.out.println("1. From English to Morse Code.");
        System.out.println("2. From Morse Code to English.");

        int choice = scan.nextInt();
        scan.nextLine(); // take in the newline charachter after th eonteger input

        try {
            if (choice == 1) {
                System.out.println("Please write a text in English: ");
                String inputText = scan.nextLine();
                String morseCode = MorseCodeConverter.englishToMorse(inputText);  //Converting to Morse Code
                if (!morseCode.isEmpty()) {
                    // if the input is not empty then we print the converted Morse code
                    System.out.println("Morse Code: " + morseCode);
                }
            } else if (choice == 2) {
                System.out.println("Please write in Morse Code: ");
                String inputMorse = scan.nextLine();
                String englishText = MorseCodeConverter.morseToEnglish(inputMorse);    //converting to English
                if (!englishText.isEmpty()) {
                    //If the input is not empty then we print converted English text
                    System.out.println("English text: " + englishText);
                }
            } else {
                // if the input is an invalid choice
                System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            //If any exception happends we will get an error message
            System.out.println("Error! " + e.getMessage());
        }
    }
}
