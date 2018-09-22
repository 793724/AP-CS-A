
/**
 * Project 2 - Ball Runner
 *
 * @author (Emma Chiu)
 * @version (914)
 */
public class BallRunner {
   
    public static void run() {
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint entrancePoint = new TGPoint(0, 0);
        int startHeading = (int)(Math.random()*360);
        int radius = 25;
        
        BallBot[] ballBotArray = new BallBot[10];
        BallRunner ballrunner = new BallRunner();

        while(1+1 == 2){
            int freeBallBotIndex = ballrunner.findFreeBallBotIndex(ballBotArray);
            if(freeBallBotIndex < ballBotArray.length){
                ballBotArray[freeBallBotIndex] = new BallBot(ballWorld, entrancePoint, startHeading, radius);
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
}