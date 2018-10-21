/**
 * Project 3 - Magpie
 *
 * @ Emma Chiu
 * @ 1015
 */

public class Magpie3 {
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
        } else if (findKeyword(statement2, "i like") >= 0) {
            response = "What do you like about it?";
        } else if (findKeyword(statement2, "you") >= 0
            || findKeyword(statement2, "your") >= 0) {
            response = "No personal questions, please.";
        } else if (findKeyword(statement2, "i know") >= 0) {
            response = "What else do you know?";
        } else if (findKeyword(statement2, "mother") >= 0
            || findKeyword(statement2, "father") >= 0
            || findKeyword(statement2, "sister") >= 0
            || findKeyword(statement2, "brother") >= 0) {
            response = "Tell me more about your family.";
        } else if (findKeyword(statement2, "dog") >= 0
            || findKeyword(statement2, "cat") >= 0) {
            response = "Tell me more about your pets.";
        } else if (findKeyword(statement2, "ettlin") >= 0) {
            response = "He sounds like a good teacher.";
        } else if (findKeyword(statement2, "thanks") >= 0
            || findKeyword(statement2, "thank you") >= 0
            || findKeyword(statement2, "sorry") >= 0) {
            response = "No problem!";
        } else if (findKeyword(statement2, "no") >= 0) {
            response = "Why so negative?";
        } else if (findKeyword(statement2, "yes") >= 0
            || findKeyword(statement2, "yep") >= 0 
            || findKeyword(statement2, "yeah") >= 0) {
            response = "I'm glad you agree.";
        } else if (statement2.trim().length() == 0) {
            // when there is no input (spaces don't count)
            response = "Say something, please.";
        } else {
            // gets a generic response if none of the keywords are found
            response = getRandomResponse();
        }
        // chatbot's reply to user input
        return response;
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
        // number of possible random responses
        final int NUMBER_OF_RESPONSES = 7;
        // random number
        double r = Math.random();
        // uses the random number and number of responses to choose a random response
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        // possible responses
        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        } else if (whichResponse == 1) {
            response = "Hmmm.";
        } else if (whichResponse == 2) {
            response = "Do you really think so?";
        } else if (whichResponse == 3) {
            response = "You don't say.";
        } else if (whichResponse == 4) {
            response = "I've never considered that.";
        } else if (whichResponse == 5) {
            response = "Well, that's nice.";
        } else if (whichResponse == 6) {
            response = "Ohh, I see.";
        }

        // chatbot "says" the random response
        return response;
    }
}