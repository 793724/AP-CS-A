import java.util.Random;
/**
 * Test Two Review
 *
 * @ Emma Chiu
 * @ 1106
 */

public class MagPie {
    public static void main() {
        System.out.println(transformIHaveA("I have a puppy"));
    }
    
    public static String transformIHaveA(String statement) {
        // Remove the final period, if there is one
	statement = statement.toLowerCase().trim();
	String lastChar = statement.substring(statement.length() - 1);
	if (lastChar.equals(".")) {
	    statement = statement.substring(0, statement.length() - 1);
	}

	int psn = statement.indexOf("i have a");
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