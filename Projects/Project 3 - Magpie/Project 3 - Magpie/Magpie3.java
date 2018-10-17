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
    public String getResponse(String statement) {
        String response = "";
        if (statement.indexOf("hi") >= 0
            || statement.indexOf("hello") >= 0
            || statement.indexOf("greetings") >=0
            || statement.indexOf("hey") >= 0
            || statement.indexOf("hola") >= 0
            || statement.indexOf("sup") >= 0) {
            response = "Hi, nice to meet you.";
        } else if (statement.indexOf("i like") >= 0) {
            response = "What do you like about it?";
        } else if (statement.indexOf("you") >= 0
            || statement.indexOf("your") >= 0) {
            response = "No personal questions, please.";
        } else if (statement.indexOf("i know") >= 0) {
            response = "What else do you know?";
        } else if (statement.indexOf("mother") >= 0
            || statement.indexOf("father") >= 0
            || statement.indexOf("sister") >= 0
            || statement.indexOf("brother") >= 0) {
            response = "Tell me more about your family.";
        } else if (statement.indexOf("dog") >= 0
            || statement.indexOf("cat") >= 0) {
            response = "Tell me more about your pets.";
        } else if (statement.indexOf("ettlin") >= 0) {
            response = "He sounds like a good teacher.";
        } else if (statement.indexOf("thanks") >= 0
            || statement.indexOf("thank you") >= 0
            || statement.indexOf("sorry") >= 0) {
            response = "No problem!";
        } else if (statement.indexOf("no") >= 0) {
            response = "Why so negative?";
        } else if (statement.indexOf("yes") >= 0
            || statement.indexOf("yep") >= 0 
            || statement.indexOf("yeah") >= 0) {
            response = "I'm glad you agree.";
        } else if (statement.trim().length() == 0) {
            response = "Say something, please.";
        } else {
            response = getRandomResponse();
        }
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
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword(statement, goal, 0);
	}

    /**
     * Pick a default response to use if nothing else fits.
     * @ return a non-committal string
     */
    private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1) {
            response = "Hmmm.";
        }
        else if (whichResponse == 2) {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3) {
            response = "You don't say.";
        }
        else if (whichResponse == 4) {
            response = "I've never considered that.";
        }
        else if (whichResponse == 5) {
            response = "Well, that's nice.";
        }

        return response;
    }
}
