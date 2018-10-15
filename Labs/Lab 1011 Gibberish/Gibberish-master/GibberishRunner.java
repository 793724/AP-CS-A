
/**
 * Lab 1011 Gibberish
 *
 * @ Emma Chiu
 * @ 1011
 */

public class GibberishRunner {
    // main method
    public static void main() {
        // creates a new word list object
        WordList5000 wordList5000 = new WordList5000();
        // creates a new gibberish object
        Gibberish gibberish = new Gibberish();
        // calls the make gibberish method and prints out the gibberish
        System.out.println(gibberish.makeGibberish(wordList5000));
    }
}