import java.util.Random;
/**
 * Project 3 - Magpie
 *
 * @ Laurie White
 * @ Emma Chiu
 * @ 1015
 * 
 * BEST VERSION; RUN THIS!
 */

public class Magpie5 {
    /**
    * Get a default greeting    
    * @ return a greeting
    */
    public String getGreeting() {
        return "Hello, let's talk.";
    }
    
    /**
    * Gives a response to a user statement
    * @ param statement
    * @ the user statement
    * @ return a response based on the rules given
    */
    public String getResponse(String statement1) {
        // declares and initializes chatbot's response
        String response = "";
        // converts user input to lower case
        String statement2 = statement1.toLowerCase();
        // various responses given by detected keywords
        // added feature: keyword must stand on its own (can't be within another word)
        if (findKeyword(statement2, "hi") >= 0
            || findKeyword(statement2, "hello") >= 0
            || findKeyword(statement2, "greetings") >=0
            || findKeyword(statement2, "hey") >= 0
            || findKeyword(statement2, "hola") >= 0
            || findKeyword(statement2, "sup") >= 0) {
            response = "Hi, nice to meet you.";
        } else if(statement2.trim().equals("how are you")
            || statement2.trim().equals("how are you doing")
            || statement2.trim().equals("how are you today")
            || statement2.trim().equals("how are you?")
            || statement2.trim().equals("how are you doing?")
            || statement2.trim().equals("how are you today?")) {
            response = "I'm well, thanks, and you?";
        } else if(statement2.trim().equals("who are you")
            || statement2.trim().equals("who are you?")
            || statement2.trim().equals("what are you")
            || statement2.trim().equals("what are you?")) {
            response = "I'm a chatbot; my name is Emma 2.0.";
        } else if (findKeyword(statement2, "i like") >= 0 && findKeyword(statement2, "you", 0) < 0 && statement2.trim().length() > 6) {
            response = transformLikeStatement(statement2);
        } else if(findKeyword(statement2, "i know about") >= 0) {
            int psn = findKeyword(statement2, "i know about");
            response = "What do you know about " + statement2.substring(psn + 13) + "?";
        } else if (findKeyword(statement2, "i know") >= 0) {
            response = "What else do you know?";
        } else if(findKeyword(statement2, "my name is") >= 0) {
            response = transformNameStatement(statement2);
        } else if(findKeyword(statement2, "you're welcome") >= 0
            || findKeyword(statement2, "you are welcome") >= 0) {
            response = "I will eternally be in your debt. :)";
        } else if (findKeyword(statement2, "mother") >= 0
            || findKeyword(statement2, "father") >= 0
            || findKeyword(statement2, "sister") >= 0
            || findKeyword(statement2, "brother") >= 0) {
            response = "Interesting, tell me more about your family.";
        } else if (findKeyword(statement2, "dog") >= 0
            || findKeyword(statement2, "cat") >= 0) {
            response = "Hmm, tell me more about your pets.";
        } else if (findKeyword(statement2, "ettlin") >= 0) {
            response = "He sounds like a good teacher.";
        } else if (findKeyword(statement2, "thanks") >= 0
            || findKeyword(statement2, "thank you") >= 0
            || findKeyword(statement2, "sorry") >= 0) {
            response = "No problem!";
        } else if (findKeyword(statement2, "haha") >= 0
            || findKeyword(statement2, ":)") >= 0
            || findKeyword(statement2, "ha") >= 0
            || findKeyword(statement2, "xd") >= 0
            || findKeyword(statement2, "xp") >= 0
            || findKeyword(statement2, ":p") >= 0
            || findKeyword(statement2, "lol") >= 0) {
            response = ";)";
        } else if (findKeyword(statement2, "no") >= 0
            || findKeyword(statement2, "nope") >= 0
            || findKeyword(statement2, "nah") >= 0) {
            response = "Why so negative?";
        } else if (findKeyword(statement2, "yes") >= 0
            || findKeyword(statement2, "yep") >= 0 
            || findKeyword(statement2, "yeah") >= 0) {
            response = "I'm glad you think so.";
        } else if(findKeyword(statement2, "i want", 0) >= 0 && statement2.trim().length() > 6) {
            // responses which require transformations
            response = transformIWantToStatement(statement2);
        } else if(statement2.trim().equals("because")
            || statement2.trim().equals("because.")) {
            response = "That's not a very good reason, is it?";
        } else if(statement2.trim().equals("why")
            || statement2.trim().equals("why?")) {
            response = "That's a good question.";
        } else if (statement2.trim().length() == 0) {
            // when there is no input (spaces don't count)
            response = "Say something, please.";
        } else if (findKeyword(statement2, "you", 0) >= 0) {
            // look for a two word (you <something> me) pattern or a (I <something> you) pattern
            int psnY = findKeyword(statement2, "you", 0);
            int psnM = findKeyword(statement2, "me", 0);
            int psnI = findKeyword(statement2, "I", 0);
            if (psnY >=0 && psnM >=0) {
                response = transformYouMeStatement(statement2);
            } else if (psnI >= 0 && psnY >= 0){
                response = transformYouIStatement(statement2);
            } else {
                response = "No personal questions, please.";
            }
        } else {
            // gets a generic response if none of the keywords are found
            response = getRandomResponse();
        }
        // chatbot's reply to user input
        return response;
    }
    
    /**
    * Take a statement with "I want to <something>." and transform it into 
    * "What would it mean to <something>?"
    * @ param statement the user statement, assumed to contain "I want to"
    * @ return the transformed statement
    */
    private String transformIWantToStatement(String statement){
        //  Remove the final period, if there is one
	statement = statement.trim();
	String lastChar = statement.substring(statement.length() - 1);
	if (lastChar.equals(".")) {
	    statement = statement.substring(0, statement.length() - 1);
	}
	if (statement.indexOf("i want to") >= 0){
	    int psnVerb = findKeyword(statement, "i want to", 0);
	    String restOfStatement = statement.substring(psnVerb + 9).trim();
	    return "Would you really be happy if you could " + restOfStatement + "?";
	} else {
	    int psnNoun = findKeyword (statement, "i want", 0);
	    String restOfStatement = statement.substring(psnNoun + 6).trim();
	    return "Would you really be happy if you had " + restOfStatement + "?";
	}
    }

    /**
    * Take a statement with "you <something> me" and transform it into 
    * "What makes you think that I <something> you?"
    * @ param statement the user statement, assumed to contain "you" followed by "me"
    * @ return the transformed statement
    */
    private String transformYouMeStatement(String statement) {
        // Remove the final period, if there is one
	statement = statement.trim();
	String lastChar = statement.substring(statement.length() - 1);
	if (lastChar.equals(".")) {
	    statement = statement.substring(0, statement.length() - 1);
	}
	
	int psnOfYou = findKeyword (statement, "you", 0);
	int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
	
	String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
	return "What makes you think that I " + restOfStatement + " you?";
    }
    
    /**
    * Take a statement with "I <something> you" and transform it into 
    * "Why do you <something> me?"
    * @ param statement the user statement, assumed to contain "I" followed by "you"
    * @ return the transformed statement
    */
    private String transformYouIStatement(String statement) {
        // Remove the final period, if there is one
	statement = statement.trim();
	String lastChar = statement.substring(statement.length() - 1);
	if (lastChar.equals(".")) {
	    statement = statement.substring(0, statement.length() - 1);
	}
	
	int psnOfI = findKeyword (statement, "i", 0);
	int psnOfYou = findKeyword (statement, "you", psnOfI + 1);

	String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
	return "Why do you " + restOfStatement + " me?";
    }
    
    /**
    * Take a statement with "I like <something>" and transform it into 
    * "Why do you like <something>?" if a verb or "What do you like about <something>?" if a noun
    * @ param statement the user statement, assumed to contain "I" followed by "you"
    * @ return the transformed statement
    */
    private String transformLikeStatement(String statement) {
        // Remove the final period, if there is one
	statement = statement.trim();
	String lastChar = statement.substring(statement.length() - 1);
	if (lastChar.equals(".")) {
	    statement = statement.substring(0, statement.length() - 1);
	}

	int psn = findKeyword(statement, "i like");
        if(findKeyword(statement, "i like to") >= 0) {
           return "Why do you like " + statement.substring(psn + 7) + "?";
        } else {
           return "What do you like about " + statement.substring(psn + 7) + "?";
        }
    }
    
    /**
    * Take a statement with "My name is <something>" and transform it into 
    * "It's a pleasure to meet you, <something>"
    * @ param statement the user statement, assumed to contain "I" followed by "you"
    * @ return the transformed statement
    */
    private String transformNameStatement(String statement) {
        // Remove the final period, if there is one
	statement = statement.trim();
	String lastChar = statement.substring(statement.length() - 1);
	if (lastChar.equals(".")) {
	    statement = statement.substring(0, statement.length() - 1);
	}

	int psn = findKeyword(statement, "my name is");
        return "It's a pleasure to meet you, " + statement.substring(psn + 11) + ".";
    }
    
    /**
    * Search for one word in phrase. The search is not case
    * sensitive. This method will check that the given goal
    * is not a substring of a longer string (so, for
    * example, "I know" does not contain "no").
    *
    * @ param statement
    * the string to search
    * @ param goal
    * the string to search for
    * @ param startPos
    *  the character of the string to begin the
    *  search at
    * @ return the index of the first occurrence of goal in
    * statement or -1 if it's not found
    */
    private int findKeyword(String statement, String goal, int startPos) {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();
        // The only change to incorporate the startPos is in the line below
        int psn = phrase.indexOf(goal, startPos);
        // Refinement--make sure the goal isn't part of a word
        while (psn >= 0) {
            // Find the string of length 1 before and after the word
            String before = " ", after = " ";
            if (psn > 0) {
        	before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length()) {
        	after = phrase.substring(psn + goal.length(), psn + goal.length() + 1);
            }
            // If before and after aren't letters, we've found the word
            if (((before.compareTo("a") < 0)
                || (before.compareTo("z") > 0)) // before is not a
                && ((after.compareTo("a") < 0)
                || (after.compareTo("z") > 0))) {
        	return psn;
            }
        
            // The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal, psn + 1);
        }
        return -1;
	}

    /**
    * Search for one word in phrase. The search is not case
    * sensitive. This method will check that the given goal
    * is not a substring of a longer string (so, for
    * example, "I know" does not contain "no"). The search
    * begins at the beginning of the string.
    * 
    * @ param statement
    * the string to search
    * @ param goal
    * the string to search for
    * @ return the index of the first occurrence of goal in
    * statement or -1 if it's not found
    */
    private int findKeyword(String statement, String goal) {
        // shortened method; starting position is unnecessary
        return findKeyword(statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @ return a non-committal string
     */
    private String getRandomResponse() {
	Random r = new Random ();
	return randomResponses[r.nextInt(randomResponses.length)];
    }
	
    private String [] randomResponses = {
        "Interesting, tell me more.",
	"Hmmm.",
	"Do you really think so?",
	"You don't say.",
	"I've never considered that.",
	"Well, that's nice.",
	"Ohh, I see.",
	"Huh, I haven't thought of that.",
	"Ohh, okay.",
	"That's interesting.",
	"Is that what you think?"
	};
}