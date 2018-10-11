
/**
 * Lab 1011 Gibberish
 *
 * @ Emma Chiu
 * @ 1011
 */

public class GibberishRunner {
    public static void main() {
        WordList5000 wordList5000 = new WordList5000();
        Gibberish gibberish = new Gibberish();
        System.out.println(gibberish.makeGibberish(wordList5000));
    }
}
