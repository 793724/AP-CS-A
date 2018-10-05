
/**
 * Lab 1005 Sentence Builder
 *
 * @ Emma Chiu
 * @ 1005
 * 
 * FIX LOAD SENTENCE; NEED CONSTRUCTOR?
 */

public class Sentence {
    
    private String[] nouns = {"box", "cat", "cloud", "shell"};
    private String[] verbs = {"runs", "leaps", "flies", "sleeps"};
    private String[] adjectives = {"fluffy", "wooden", "circular", "ornate"};
    private String[] adverbs = {"quickly", "rarely", "eagerly", "sleepily"};
    private String[] determiners = {"the", "my", "his", "her"};
    private String[] prepositions = {"over", "near", "under", "through"};
    
    // public void loadSentence(){
        // String sentence = getNounPhrase() + getVerbPhrase() + getPrepositionalPhrase();
    // }
    
    public String getSentence(){
        return getNounPhrase() + " " + getVerbPhrase() + " " + getPrepositionalPhrase() + ".";
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
