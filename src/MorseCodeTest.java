import org.junit.Test;
//import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

public class MorseCodeTest {

    //TestCase for converting valid English text to Morse code
    @Test
    public void testEnglishToMorse() {
    assertEquals(".-", MorseCodeConverter.englishToMorse("A"));
    assertEquals("-...", MorseCodeConverter.englishToMorse("B"));
    assertEquals(".... . .-.. .-.. ---", MorseCodeConverter.englishToMorse("H E L L O"));
    }

    //TestCase for converting valid Morse code to English text
    @Test
    public void testMorseToEnglish() {
        assertEquals("A", MorseCodeConverter.morseToEnglish(".-"));
        assertEquals("B", MorseCodeConverter.morseToEnglish("-..."));
        assertEquals("H E L L O", MorseCodeConverter.morseToEnglish(".... . .-.. .-.. ---"));
    }

    //TestCase for invalid English input
    @Test
    public void testEnglishToMoreInvalidChacacter() {
        String result = MorseCodeConverter.englishToMorse("1");
        assertEquals("", result);     // we are expecting an empty string because its an error
    }

    //TestCase for invalid Morse code input
    @Test
    public void testMorseToEnglishInvalidInput() {
        String result = MorseCodeConverter.morseToEnglish(".... . .-.. .-.. ----");
        assertEquals("", result);    // we are expecting an empty string cause its an error
    }

    //TestCase for an empty Morse code input
    @Test
    public void testMorseToEnglisEmptyInput() {
        assertEquals("", MorseCodeConverter.morseToEnglish(""));
    }


}
