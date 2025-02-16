import java.util.HashMap;
import java.util.Map;

public class MorseCodeConverter {
    private static final Map<Character, String> fromEnglishToMorse;
    private static final Map<String, Character> fromMorseToEnglish;

    //initializing the mappings
    static {
        fromEnglishToMorse = new HashMap<>();
        //Here we fill fromEnglishToMorse map with characters and their corresponding Morse code
        fromEnglishToMorse.put('A', ".-");
        fromEnglishToMorse.put('B', "-...");
        fromEnglishToMorse.put('C', "-.-.");
        fromEnglishToMorse.put('D', "-..");
        fromEnglishToMorse.put('E', ".");
        fromEnglishToMorse.put('F', "..-.");
        fromEnglishToMorse.put('G', "--.");
        fromEnglishToMorse.put('H', "....");
        fromEnglishToMorse.put('I', "..");
        fromEnglishToMorse.put('J', ".---");
        fromEnglishToMorse.put('K', "-.-");
        fromEnglishToMorse.put('L', ".-..");
        fromEnglishToMorse.put('M', "--");
        fromEnglishToMorse.put('N', "-.");
        fromEnglishToMorse.put('O', "---");
        fromEnglishToMorse.put('P', ".--.");
        fromEnglishToMorse.put('Q', "--.-");
        fromEnglishToMorse.put('R', ".-.");
        fromEnglishToMorse.put('S', "...");
        fromEnglishToMorse.put('T', "-");
        fromEnglishToMorse.put('U', "..-");
        fromEnglishToMorse.put('V', "...-");
        fromEnglishToMorse.put('W', ".--");
        fromEnglishToMorse.put('X', "-..-");
        fromEnglishToMorse.put('Y', "-.--");
        fromEnglishToMorse.put('Z', "--..");

        //initializing the reverse map
        fromMorseToEnglish = new HashMap<>();
        for (Map.Entry<Character, String> entry : fromEnglishToMorse.entrySet()) {
            fromMorseToEnglish.put(entry.getValue(), entry.getKey());
        }
    }

    //Method to convert English text to Morse code
    public static String englishToMorse(String english) {
        StringBuilder morseCode = new StringBuilder();   // to store the result in Morse code.
        try {
            //Loop through every character in the input English string
            for (char c : english.toUpperCase().toCharArray()) {
                if ( c == ' ') {
                    morseCode.append(" ");  // spacing between words in Morse code
                } else {
                    // Retrive the corresponding Morse code from the map
                    String morse = fromEnglishToMorse.get(c);
                    if (morse == null) {
                        //If the character does not have a Morse equivalent, throw an exception
                        throw new IllegalArgumentException("Invalid chharacter input: " + c);
                    }
                    morseCode.append(morse).append(" "); //append the morse code for the characters

                }
            }
        } catch (IllegalArgumentException e ) {
            System.out.println("Error! " + e.getMessage()); //printing an error message dor the invalid input
            return "";  // We return an empty string if an error happends
        }
        return morseCode.toString().trim(); // returning the final Morse code string
    }

    // Method to convert Morse code back to English text
    public static String morseToEnglish(String morse) {
        StringBuilder englishText =  new StringBuilder();    // storing the result in English
        try {
            String[] morseWords = morse.split("  "); // separating Morse code into wprds by spacing
            for (String word : morseWords) {
                String[] morseLetters = word.split(" ");    //spliting each word into Morse letters
                for (String letter : morseLetters) {
                    //Retrive the corresponding English letter from the Morse code
                    Character englishChar = fromMorseToEnglish.get(letter);
                    if (englishChar == null) {
                        //If the Morse code does not have a corresponding English letter then throw an expection
                        throw new IllegalArgumentException("Invalid Morse code: " + letter);
                    }
                    englishText.append(englishChar);   //Append the English letter
                }
                englishText.append(" "); //adding space between words
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());  //Print the error message for invalid Morse code
            return "";     // returning empty string if an error happends
        }
        return englishText.toString().trim();  // returning the final English text
    }
}