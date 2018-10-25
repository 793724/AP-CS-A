import java.util.Scanner;

/**
 * Project 3 - Magpie
 *
 * @ Laurie White
 * @ Emma Chiu
 * @ 1015
 * 
 * MAGPIERUNNER5 IS THE BEST VERSION- RUN THAT!
 */

public class MagpieRunner3 {
    /**
    * Create a Magpie, give it user input, and print its replies.
    */
    public static void main(String[] args) {
        // new magpie object
        Magpie3 maggie = new Magpie3();
		
        // opens conversation and user response
	System.out.println (maggie.getGreeting());
	Scanner in = new Scanner (System.in);
	String statement = in.nextLine();
	
	// added the extra "bye" so that lowercase works as well
	while (!statement.equals("Bye") && !statement.equals("bye")) {
            // ends program
	    System.out.println (maggie.getResponse(statement));
	    statement = in.nextLine();
	}
    }
}