
/**
 * Project 2 - Ball Runner
 *
 * @author (Emma Chiu)
 * @version (914)
 */

public class BallRunner {
    public static void activity1() {
        // Creates a ball that travels around the edges of the window
        BallWorld ballWorld = new BallWorld(200, 200); // Declare and initialize variables
        TGPoint startPoint = new TGPoint(0, 0);
        int startHeading = 0;
        int radius = 25;
        BallBot ballBot = new BallBot(ballWorld, startPoint, startHeading, radius); // Create a new ball bot
        while(1+1 == 2){ // Endless loop that moves the ball bot
            if(ballBot.canMoveForward(ballWorld) == true){ // Moves forward when possible
                ballBot.moveForward();
            } else { // Ball bot turns right when it runs into a wall
                startHeading = (startHeading + 90) % 360;
                ballBot.setHeading(startHeading);
            }
        }
    }

    public static void activity2() {
        // Creates ten balls that bounce around the window
        BallWorld ballWorld = new BallWorld(200, 200); // Declare and initialize variables
        TGPoint entrancePoint = new TGPoint(0, 0);
        int radius = 25;
        
        BallBot[] ballBotArray = new BallBot[10]; // Declares an array of ball bots
        BallRunner ballrunner = new BallRunner();

        while(1+1 == 2){ // Endless loop that moves the ball bot
            int freeBallBotIndex = ballrunner.findFreeBallBotIndex(ballBotArray); // Sees if there's fewer than ten ball bots
            if(freeBallBotIndex < ballBotArray.length){
                ballBotArray[freeBallBotIndex] = new BallBot(ballWorld, entrancePoint, Math.random()*360.0, radius); // If fewer than ten ball bots, make a new one
            }

            for(int index = 0; index < ballBotArray.length; index++){ // Moves each individual ball bot
                if(ballBotArray[index] != null){
                    if(ballBotArray[index].canMoveForward(ballWorld) == true){
                        ballBotArray[index].moveForward(); // Moves forward when possible
                    } else {
                        ballBotArray[index].setHeading(Math.random()*360.0); // Hits a wall? Bounce in a random direction
                    }
                }
            }
        }
    }
    
    public int findFreeBallBotIndex(BallBot[] ballBotArray) {
        boolean nullValue = false; // Declares and initializes variables
        int index = 0;
        for(int i = 0; i < ballBotArray.length && nullValue == false; i++){ // Checks to see if any of the indices in the ball bot array are empty
            if(ballBotArray[i] == null){
                nullValue = true;
                index = i;
            }
        }
        if(nullValue == true){ // Returns the index of the free spot in the array (if there is one)
            return index;
        } else {
            return ballBotArray.length;
        }
    }
    
    public static void activity3() {
        // Creates ten balls, one at a time, that bounce around the window
        BallWorld ballWorld = new BallWorld(200, 200); // Declares and initializes variables
        TGPoint entrancePoint = new TGPoint(0, 0);
        int radius = 25;
        
        BallBot[] ballBotArray = new BallBot[10]; // Declares a new array of ten ball bots
        BallRunner ballrunner = new BallRunner();

        while(1+1 == 2){ // Endless loop that moves the ball bots
            if(ballrunner.entranceClear(ballBotArray, entrancePoint) == true){ // Checks to see if there's room to spawn a new ball bot
                int freeBallBotIndex = ballrunner.findFreeBallBotIndex(ballBotArray);
                if(freeBallBotIndex < ballBotArray.length){ // Checks to see if there are fewer than ten ball bots
                    ballBotArray[freeBallBotIndex] = new BallBot(ballWorld, entrancePoint, Math.random()*360.0, radius); // If so, create a new one
                }
            }
            for(int index = 0; index < ballBotArray.length; index++){ // Motion for each of the ball bots
                if(ballBotArray[index] != null){
                    if(ballBotArray[index].canMoveForward(ballWorld) == true){
                        ballBotArray[index].moveForward(); // Moves forward when possible
                    } else {
                        ballBotArray[index].setHeading(Math.random()*360.0); // Hits a wall? Bounce in a random direction
                    }
                }
            }
        }
    }
    
    public double distanceBetweenPoints(TGPoint point1, TGPoint point2){
        double xDiff = point1.x - point2.x; // Change in x
        double yDiff = point1.y - point2.y; // Change in y
        double squareX = Math.pow(xDiff, 2); // Square of delta x
        double squareY = Math.pow(yDiff, 2); // Square of delta y
        return Math.sqrt(squareX + squareY); // Returns distance between the points
    }
    
    public boolean entranceClear(BallBot[] ballBotArray, TGPoint entrancePoint){
        boolean clear = true;
        for(int i = 0; i < ballBotArray.length; i++){ // Runs through array
            if(ballBotArray[i] != null){ // For each element in the array...
                double distance = distanceBetweenPoints(ballBotArray[i].getPoint(), entrancePoint); // Checks the distance between the ball bots and the entrance point
                if(distance < ballBotArray[i].getRadius() * 2){ // If there's not enough room, the entrance isn't clear
                    clear = false;
                }
            }
        }
        return clear; // This will determine if there's space to spawn another ball bot or not
    }
    
    public static void activity4() {
        // Creates ten balls, one at a time, that bounce around the window and off each other
        BallWorld ballWorld = new BallWorld(200, 200); // Declare and initialize variables
        TGPoint entrancePoint = new TGPoint(0, 0);
        int radius = 25;
        
        BallBot[] ballBotArray = new BallBot[10]; // Declare an array of ten ball bots
        BallRunner ballrunner = new BallRunner();

        while(1+1 == 2){ // Infinite loop that moves the ball bots
            if(ballrunner.entranceClear(ballBotArray, entrancePoint) == true){ // If the entrance is clear...
                int freeBallBotIndex = ballrunner.findFreeBallBotIndex(ballBotArray);
                if(freeBallBotIndex < ballBotArray.length){ // ... and there are fewer than ten ball bots... 
                    ballBotArray[freeBallBotIndex] = new BallBot(ballWorld, entrancePoint, Math.random()*360.0, radius); // ... create a new ball bot!
                }
            }
            for(int index = 0; index < ballBotArray.length; index++){ // Runs through all the ball bots
                if(ballBotArray[index] != null){ // True if the ball bot exists (element in array is filled)
                    if(ballBotArray[index].canMoveForward(ballWorld) == true){
                        if(ballrunner.ballBotToBounceOff(ballBotArray[index], ballBotArray) == null){
                            ballBotArray[index].moveForward(); // Moves forward if it's not touching another ball bot or a wall
                        } else {
                            ballBotArray[index].setHeading(Math.random()*360.0); // Bounces in a random direction if it's touching another ball bot
                        }
                    } else {
                        ballBotArray[index].setHeading(Math.random()*360.0); // Bounces in a random direction if it's touching a wall
                    }
                }
            }
        }
    }
    
    public BallBot ballBotToBounceOff(BallBot ballBot, BallBot[] ballBotArray){
        TGPoint point = ballBot.getPoint(); // Declare and initialize variables
        TGPoint nextPoint = ballBot.forwardPoint();
        
        for(int i = 0; i < ballBotArray.length; i++){
            BallBot otherBallBot = ballBotArray[i];
            if(otherBallBot != null && otherBallBot != ballBot){
                double currentDistance = distanceBetweenPoints(point, otherBallBot.getPoint()); // Current distance between the ball bots
                if(currentDistance <= ballBot.getRadius() + otherBallBot.getRadius()){
                    double nextDistance = distanceBetweenPoints(nextPoint, otherBallBot.getPoint()); // Distance between the ball bots if it moved forward
                    if(nextDistance <= currentDistance){
                        return otherBallBot; // Should it bounce or not?
                    }
                }
            }
        }
        
        return null;
    }
    
    public static void activity5() {
        // Creates twenty balls, one at a time, that bounce around the window and off each other
        // The balls have a variety of colors, sizes, and speeds, and the window is larger
        BallWorld ballWorld = new BallWorld(800, 800); // Declare and initialize variables
        TGPoint entrancePoint = new TGPoint(0, 0);
        
        BallBot[] ballBotArray = new BallBot[20]; // Declare an array of twenty ball bots
        BallRunner ballrunner = new BallRunner();

        while(1+1 == 2){ // Infinite loop that creates and moves the ball bots
            if(ballrunner.entranceClear(ballBotArray, entrancePoint) == true){ // Whether or not there's room to spawn a new ball bot
                int freeBallBotIndex = ballrunner.findFreeBallBotIndex(ballBotArray);
                if(freeBallBotIndex < ballBotArray.length){ // If true, create a ball bot with a random color, size, and speed!
                    ballBotArray[freeBallBotIndex] = new BallBot(ballWorld, entrancePoint, Math.random()*360.0, (int)(Math.random()*56+5));
                    ballBotArray[freeBallBotIndex].setColor((int)(Math.random()*32));
                    ballBotArray[freeBallBotIndex].setPixelsPerSecond((int)(Math.random()*250+10));
                }
            }
            for(int index = 0; index < ballBotArray.length; index++){ // Motion for each ball bot
                if(ballBotArray[index] != null){
                    if(ballBotArray[index].canMoveForward(ballWorld) == true){
                        if(ballrunner.ballBotToBounceOff(ballBotArray[index], ballBotArray) == null){ // Keep going if there's no ball bot or wall in the way
                            ballBotArray[index].moveForward();
                        } else {
                            ballBotArray[index].setHeading(Math.random()*360.0); // Bounce off other balls
                        }
                    } else {
                        ballBotArray[index].setHeading(Math.random()*360.0); // Bounce off walls
                    }
                }
            }
        }
    }
    
    public static void activity6() {
        // Unfinished attempt to modify activity 5 so the angle of incidence equals the angle of reflection
        BallWorld ballWorld = new BallWorld(800, 800); // Declare and initialize variables
        TGPoint entrancePoint = new TGPoint(0, 0);
        
        BallBot[] ballBotArray = new BallBot[20]; // Declare an array of twenty ball bots
        BallRunner ballrunner = new BallRunner();

        while(1+1 == 2){ // Infinite loop that creates and moves the ball bots
            if(ballrunner.entranceClear(ballBotArray, entrancePoint) == true){ // Whether or not there's room to spawn a new ball bot
                int freeBallBotIndex = ballrunner.findFreeBallBotIndex(ballBotArray);
                if(freeBallBotIndex < ballBotArray.length){ // If true, create a ball bot with a random color, size, and speed!
                    ballBotArray[freeBallBotIndex] = new BallBot(ballWorld, entrancePoint, Math.random()*360.0, (int)(Math.random()*56+5));
                    ballBotArray[freeBallBotIndex].setColor((int)(Math.random()*32));
                    ballBotArray[freeBallBotIndex].setPixelsPerSecond((int)(Math.random()*250+10));
                }
            }
            for(int index = 0; index < ballBotArray.length; index++){ // Motion for each ball bot
                if(ballBotArray[index] != null){
                    if(ballBotArray[index].canMoveForward(ballWorld) == true){
                        if(ballrunner.ballBotToBounceOff(ballBotArray[index], ballBotArray) == null){ // Keep going if there's no ball bot or wall in the way
                            ballBotArray[index].moveForward();
                        } else {
                            ballBotArray[index].setHeading(Math.random()*360.0); // Bounce off other balls
                        }
                    } else {
                        // if current angle 0-90, x = 180; 90-180, x = 270; 180-270, x = 360
                        int x = 180;
                        ballBotArray[index].setHeading(x + ballBotArray[index].getHeading() % 90); // Not working yet!
                    }
                }
            }
        }
    }
}