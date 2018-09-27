
/**
 * Project 2 - Ball Runner
 *
 * @author (Emma Chiu)
 * @version (914)
 */
public class BallRunner {
    public static void activity1() {
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint startPoint = new TGPoint(0, 0);
        int startHeading = 0;
        int radius = 25;
        BallBot ballBot = new BallBot(ballWorld, startPoint, startHeading, radius);
        while(1+1 == 2){
            if(ballBot.canMoveForward(ballWorld) == true){
                ballBot.moveForward();
            } else {
                startHeading = (startHeading + 90) % 360;
                ballBot.setHeading(startHeading);
            }
        }
    }

    public static void activity2() {
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint entrancePoint = new TGPoint(0, 0);
        int startHeading = (int)(Math.random()*360);
        int radius = 25;
        
        BallBot[] ballBotArray = new BallBot[10];
        BallRunner ballrunner = new BallRunner();

        while(1+1 == 2){
            int freeBallBotIndex = ballrunner.findFreeBallBotIndex(ballBotArray);
            if(freeBallBotIndex < ballBotArray.length){
                ballBotArray[freeBallBotIndex] = new BallBot(ballWorld, entrancePoint, (int)(Math.random()*360), radius);
            }

            for(int index = 0; index < ballBotArray.length; index++){
                if(ballBotArray[index] != null){
                    if(ballBotArray[index].canMoveForward(ballWorld) == true){
                        ballBotArray[index].moveForward();
                    } else {
                        startHeading = (int)(Math.random()*360);
                        ballBotArray[index].setHeading(startHeading);
                    }
                }
            }
        }
    }
    
    public int findFreeBallBotIndex(BallBot[] ballBotArray) {
        boolean nullValue = false;
        int index = 0;
        for(int i = 0; i < ballBotArray.length && nullValue == false; i++){
            if(ballBotArray[i] == null){
                nullValue = true;
                index = i;
            }
        }
        if(nullValue == true){
            return index;
        } else {
            return ballBotArray.length;
        }
    }
    
    public static void activity3() {
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint entrancePoint = new TGPoint(0, 0);
        int startHeading = (int)(Math.random()*360);
        int radius = 25;
        
        BallBot[] ballBotArray = new BallBot[10];
        BallRunner ballrunner = new BallRunner();

        while(1+1 == 2){
            if(ballrunner.entranceClear(ballBotArray, entrancePoint) == true){
                int freeBallBotIndex = ballrunner.findFreeBallBotIndex(ballBotArray);
                if(freeBallBotIndex < ballBotArray.length){
                    ballBotArray[freeBallBotIndex] = new BallBot(ballWorld, entrancePoint, (int)(Math.random()*360), radius);
                }
            }
            for(int index = 0; index < ballBotArray.length; index++){
                if(ballBotArray[index] != null){
                    if(ballBotArray[index].canMoveForward(ballWorld) == true){
                        ballBotArray[index].moveForward();
                    } else {
                        startHeading = (int)(Math.random()*360);
                        ballBotArray[index].setHeading(startHeading);
                    }
                }
            }
        }
    }
    
    public double distanceBetweenPoints(TGPoint point1, TGPoint point2){
        double xDiff = point1.x - point2.x;
        double yDiff = point1.y - point2.y;
        double squareX = Math.pow(xDiff, 2);
        double squareY = Math.pow(yDiff, 2);
        return Math.sqrt(squareX + squareY);
    }
    
    public boolean entranceClear(BallBot[] ballBotArray, TGPoint entrancePoint){
        boolean clear = true;
        for(int i = 0; i < ballBotArray.length; i++){
            if(ballBotArray[i] != null){
                double distance = distanceBetweenPoints(ballBotArray[i].getPoint(), entrancePoint);
                if(distance < ballBotArray[i].getRadius() * 2){
                    clear = false;
                }
            }
        }
        return clear;
    }
    
    public static void activity4() {
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint entrancePoint = new TGPoint(0, 0);
        int startHeading = (int)(Math.random()*360);
        int radius = 25;
        
        BallBot[] ballBotArray = new BallBot[10];
        BallRunner ballrunner = new BallRunner();

        while(1+1 == 2){
            if(ballrunner.entranceClear(ballBotArray, entrancePoint) == true){
                int freeBallBotIndex = ballrunner.findFreeBallBotIndex(ballBotArray);
                if(freeBallBotIndex < ballBotArray.length){
                    ballBotArray[freeBallBotIndex] = new BallBot(ballWorld, entrancePoint, (int)(Math.random()*360), radius);
                }
            }
            for(int index = 0; index < ballBotArray.length; index++){
                if(ballBotArray[index] != null){
                    if(ballBotArray[index].canMoveForward(ballWorld) == true){
                        ballBotArray[index].moveForward();
                    } else {
                        startHeading = (int)(Math.random()*360);
                        ballBotArray[index].setHeading(startHeading);
                    }
                }
            }
        }
    }
    
    public BallBot ballBotToBounceOff(BallBot ballBot, BallBot[] ballBotArray){
        TGPoint point = ballBot.getPoint();
        TGPoint nextPoint = ballBot.forwardPoint();
        
        for(int i = 0; i < ballBotArray.length; i++){
            BallBot otherBallBot = ballBotArray[i];
            if(otherBallBot != null && otherBallBot != ballBot){
                double currentDistance = distanceBetweenPoints(ballBot.getPoint(), otherBallBot.getPoint());
            }
        }
        
        
        return ballBot;
    }
}