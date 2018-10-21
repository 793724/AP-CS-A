/**
 * Project 3 - Magpie
 *
 * @ Emma Chiu
 * @ 1015
 */

public class StringExplorer3 {
    public static void main(String[] args) {
        String sample = "The quick brown fox jumped over the lazy dog.";
        
        // Demonstrate the indexOf method.
        // When index is found
	int position = sample.indexOf("quick");
	System.out.println ("sample.indexOf(\"quick\") = " + position);
	// When index is not found
	int notFoundPsn = sample.indexOf("slow");
	System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn);
	// When method has a second parameter
	int secondThe = sample.indexOf("the", 5);
	System.out.println("sample.indexOf(\"the\", 5) = " + secondThe);
	
	// Demonstrate the toLowerCase method.
	// Prints the original string
	System.out.println("Before toLowerCase(), sample = " + sample);
	// Creates a new string that is the old one in lowercase
	String lowerCase = sample.toLowerCase();
	// Prints the lowercase string
	System.out.println("After toLowerCase(), the new string is " + lowerCase);
		
	// Try other methods here:
	// As of activity 3, there were no others to try!
    }
}