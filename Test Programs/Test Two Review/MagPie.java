import java.util.Random;
import java.util.ArrayList;
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
	statement = statement.toLowerCase().trim();
	int psn = statement.indexOf("i have a");
	Random r = new Random();
	ArrayList<String> randomResponses = new ArrayList<String>();
	randomResponses.add("How long have you had a ");
        randomResponses.add("What color is your ");
        randomResponses.add("When did you get your ");
        randomResponses.add("Why do you have a ");
	String randomStatement = randomResponses.get(r.nextInt(randomResponses.size()));
        return randomStatement + statement.substring(psn + 9) + "?";
    }
}