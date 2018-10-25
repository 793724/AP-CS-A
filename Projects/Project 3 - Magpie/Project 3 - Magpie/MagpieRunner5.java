import java.util.Scanner;

/**
 * Project 4 - Magpie
 *
 * @ Laurie White
 * @ Emma Chiu
 * @ 1015
 * 
 * BEST VERSION; RUN THIS!
 */

public class MagpieRunner5 {
    /**
    * Create a Magpie, give it user input, and print its replies.
    */
    public static void main(String[] args) {
        // new magpie object
        Magpie5 maggie = new Magpie5();
		
        // opens conversation and user response
	System.out.println (maggie.getGreeting());
	Scanner in = new Scanner (System.in);
	String statement = in.nextLine();
	
	// added other possible statements and took capitalization into account
	while (!statement.trim().toLowerCase().equals("goodbye")
	    && !statement.trim().toLowerCase().equals("adios")
	    && !statement.trim().toLowerCase().equals("bye")
	    && !statement.trim().toLowerCase().equals("goodbye!")
	    && !statement.trim().toLowerCase().equals("goodbye.")
	    && !statement.trim().toLowerCase().equals("adios!")
	    && !statement.trim().toLowerCase().equals("adios.")
	    && !statement.trim().toLowerCase().equals("bye!")
	    && !statement.trim().toLowerCase().equals("bye.")) {
            // ends program
	    System.out.println(maggie.getResponse(statement));
	    statement = in.nextLine();
	}
	
	System.out.println("Goodbye, it was nice talking with you!");
    }
}