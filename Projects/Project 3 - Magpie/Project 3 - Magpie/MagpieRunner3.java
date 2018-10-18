import java.util.Scanner;

/**
 * Project 3 - Magpie
 *
 * @ Emma Chiu
 * @ 1015
 */

public class MagpieRunner3 {
    /**
    * Create a Magpie, give it user input, and print its replies.
    */
    public static void main(String[] args) {
        Magpie3 maggie = new Magpie3();
		
	System.out.println (maggie.getGreeting());
	Scanner in = new Scanner (System.in);
	String statement = in.nextLine();
		
	while (!statement.equals("Bye")) {
            System.out.println (maggie.getResponse(statement));
	    statement = in.nextLine();
	}
    }
}