/**
 * Project 3 - Magpie
 *
 * @ Laurie White
 * @ Emma Chiu
 * @ 1015
 */

public class Magpie2 {
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
        // declares and initializes chatbot's response
        String response = "";
        // converts user input to lower case
        statement = statement.toLowerCase();
        // various responses given by detected keywords
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