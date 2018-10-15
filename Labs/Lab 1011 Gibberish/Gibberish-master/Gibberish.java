
/**
 * Lab 1011 Gibberish
 *
 * @ Emma Chiu
 * @ 1011
 */

public class Gibberish {
    // declares an empty source string variable
    String sourceString = new String();
    // gibberish constructor
    public Gibberish() {
        // creates a new template object
        Template template = new Template();
        // initializes the source string to the template
        sourceString = template.getSourceString();
    }
    // method to make gibberish based on the source string
    public String makeGibberish(WordList5000 wordList5000) {
        // initializing variables
        int currentSourceIndex = 0;
        String resultString = new String();
        // indefinite while loop runs through the source string
        while(currentSourceIndex < sourceString.length()) {
            // checks if there is more to append to the result string
            if(sourceString.indexOf("<", currentSourceIndex) == -1){
                // puts a period at the end of the sentence (trying to add it after appending the remainder of the source string puts the period on a new line)
                resultString += ".";
                // adds the remainder of the source string to the result string and exits the loop
                resultString += sourceString.substring(currentSourceIndex);
                currentSourceIndex = sourceString.length();
            } else {
                // initializes variables to find part of speech
                int startCut = sourceString.indexOf("<", currentSourceIndex) + 1;
                int endCut = sourceString.indexOf(">", currentSourceIndex);
                // this string contains the part of speech
                String placeHolderString = sourceString.substring(startCut, endCut);
                // based on the part of speech, find a random word
                String addedString = wordList5000.getRandomWordString(placeHolderString);
                // checks to make sure there is a value being added
                if(addedString != null){
                    // appends the previous part of the source string, as well as the random word, to the result string
                    resultString += sourceString.substring(currentSourceIndex, startCut - 2) + " " + addedString;
                }
                // initialize a variable for finding the end of the part to be replaced
                int nextIndex = sourceString.indexOf("</>", currentSourceIndex) + 3;
                // increases source index; moving along the string
                currentSourceIndex = nextIndex;
            }
        }
        // returns the completed gibberish
        return resultString;
    }
}