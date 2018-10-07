
/**
 * Lab 1005 Sentence Builder
 *
 * @ Emma Chiu
 * @ 1005
 */

public class Sentence {
    
    private String[] nouns = {"box", "cat", "cloud", "shell", "photograph", "sushi", "mirror", "philosopher", "lawnmower", "flag", "carpet", "moon"};
    private String[] verbs = {"sprints", "leaps", "flies", "sleeps", "rotates", "ponders", "screams", "waltzes", "babbles", "vanishes", "smiles", "scrambles"};
    private String[] adjectives = {"fluffy", "wooden", "circular", "elaborate", "imaginary", "colorful", "cardboard", "singing", "transparent", "aggressive", "flimsy", "dead"};
    private String[] adverbs = {"hastily", "rarely", "eagerly", "sleepily", "furtively", "pensively", "harshly", "graciously", "attentively", "carelessly", "decisively", "painfully"};
    private String[] determiners = {"the", "my", "his", "her", "their", "your", "a", "our", "this", "that", "one", "the"};
    private String[] prepositions = {"over", "near", "under", "through", "around", "left of", "beyond", "despite", "across from", "toward", "behind", "right of"};
    private String sentence = "";
    
    public void loadSentences(){
        sentence = getNounPhrase() + " " + getVerbPhrase() + " " + getPrepositionalPhrase() + ".";
        sentence = sentence.substring(0,1).toUpperCase() + sentence.substring(1);
    }
    
    public String getSentence(){
        return sentence;
    }
    
    public String getRandomNoun(String[] nouns){
        return nouns[(int)(Math.random()*(nouns.length))];
    }
    
    public String getRandomVerb(String[] verbs){
        return verbs[(int)(Math.random()*(verbs.length))];
    }
    
    public String getRandomAdjective(String[] adjectives){
        return adjectives[(int)(Math.random()*(adjectives.length))];
    }
    
    public String getRandomAdverb(String[] adverbs){
        return adverbs[(int)(Math.random()*(adverbs.length))];
    }
    
    public String getRandomDeterminer(String[] determiners){
        return determiners[(int)(Math.random()*(determiners.length))];
    }
    
    public String getRandomPreposition(String[] prepositions){
        return prepositions[(int)(Math.random()*(prepositions.length))];
    }
    
    public String getNounPhrase(){
        return getRandomDeterminer(determiners) + " " + getRandomAdjective(adjectives) + " " + getRandomNoun(nouns);
    }
    
    public String getVerbPhrase(){
        return getRandomAdverb(adverbs) + " " + getRandomVerb(verbs);
    }
    
    public String getPrepositionalPhrase(){
        return getRandomPreposition(prepositions) + " " + getRandomDeterminer(determiners) + " " + getRandomAdjective(adjectives) + " " + getRandomNoun(nouns);
    }

}
