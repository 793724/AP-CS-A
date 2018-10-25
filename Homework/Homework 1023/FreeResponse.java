import java.util.Random;
/**
 * Homework 1023
 *
 * @ Emma Chiu
 * @ 1023
 */

public class FreeResponse {
    public static void main() {
        System.out.println("Free Response #1:");
        System.out.println(countCode("aaacodebbb"));
        System.out.println(countCode("codexxcode"));
        System.out.println(countCode("cozexxcope"));
        
        System.out.println();
        System.out.println("Free Response #2:");
        System.out.println(transformIHaveA("I have a puppy"));
        System.out.println(transformIHaveA("I have a headache"));
        
        System.out.println();
        System.out.println("Free Response #3:");
        System.out.println(transformIHaveATwo("I have a puppy"));
        System.out.println(transformIHaveATwo("I have a headache"));
        System.out.println(transformIHaveATwo("I have a penguin"));
        System.out.println(transformIHaveATwo("I have a sandwich"));
    }
    
    // Related code for Free Response # 1
    public static int countCode(String str) {
        int count = 0;
        for(int i = 0; i < str.length() - 4; i ++) {
            if(str.substring(i, i + 2).equals("co")
                && str.substring(i + 3, i + 4).equals("e")) {
                count++;
            }
        }
        if(str.substring(str.length() - 4, str.length() - 2).equals("co")
            && str.substring(str.length() - 1).equals("e")) {
            count++;
        }
        return count;
    }
    
    // Related code for Free Response # 2
    public static int findKeyword(String statement, String goal, int startPos) {
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

    public static int findKeyword(String statement, String goal) {
        // shortened method; starting position is unnecessary
        return findKeyword(statement, goal, 0);
    }
    
    public static String transformIHaveA(String statement) {
        // Remove the final period, if there is one
	statement = statement.toLowerCase().trim();
	String lastChar = statement.substring(statement.length() - 1);
	if (lastChar.equals(".")) {
	    statement = statement.substring(0, statement.length() - 1);
	}

	int psn = findKeyword(statement, "i have a");
        return "What color is your " + statement.substring(psn + 9) + "?";
    }
    
    // Related code for Free Response #3
    public static String transformIHaveATwo(String statement) {
        // Remove the final period, if there is one
	statement = statement.toLowerCase().trim();
	String lastChar = statement.substring(statement.length() - 1);
	if (lastChar.equals(".")) {
	    statement = statement.substring(0, statement.length() - 1);
	}

	int psn = findKeyword(statement, "i have a");
	String randomStatement = getRandomResponse();
        return randomStatement + statement.substring(psn + 9) + "?";
    }
    
    public static String getRandomResponse() {
	Random r = new Random();
	return randomResponses[r.nextInt(randomResponses.length)];
    }
	
    public static String [] randomResponses = {
        "How long have you had a ",
        "What color is your ",
        "When did you get your ",
        "Why do you have a "
	};
}