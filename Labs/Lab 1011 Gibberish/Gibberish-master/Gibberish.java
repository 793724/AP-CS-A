
/**
 * Lab 1011 Gibberish
 *
 * @ Emma Chiu
 * @ 1011
 */

public class Gibberish {
    String sourceString = new String();
    
    public Gibberish() {
        Template template = new Template();
        sourceString = template.getSourceString();
    }
    
    public String makeGibberish(WordList5000 wordList5000) {
        int currentSourceIndex = 0;
        String resultString = new String();
        while(currentSourceIndex < sourceString.length()) {
            if(sourceString.indexOf("<", currentSourceIndex) == -1 || sourceString.indexOf(">", currentSourceIndex) == -1){
                resultString += sourceString;
                currentSourceIndex = sourceString.length();
            } else {
                int startCut = sourceString.indexOf("<", currentSourceIndex) + 1;
                int endCut = sourceString.indexOf(">", currentSourceIndex);
                String placeHolderString = sourceString.substring(startCut, endCut);
                String addedString = wordList5000.getRandomWordString(sourceString.substring(startCut, startCut + 1));
                if(addedString != null){
                    resultString += addedString;
                }
                currentSourceIndex = sourceString.indexOf("</>", currentSourceIndex) + 3;
            }
        }
        return resultString;
    }
}
