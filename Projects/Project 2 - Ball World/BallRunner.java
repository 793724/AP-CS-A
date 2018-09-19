
/**
 * Project 2 - Ball Runner
 *
 * @author (Emma Chiu)
 * @version (914)
 */
public class BallRunner {
    /**
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
    */
   
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
   
    public static void activity2() {
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint entrancePoint = new TGPoint(0, 0);
        int startHeading = (int)(Math.random()*360);
        int radius = 25;
        
        BallBot[] ballBotArray = new BallBot[10];
        BallRunner ballrunner = new BallRunner();

        int freeBallBotIndex = BallBot.findFreeBallBotIndex(ballBotArray);
        while(1+1 == 2){
            if(freeBallBotIndex < ballBotArray.length){
                ballBotArray[freeBallBotIndex] = new BallBot(ballWorld, entrancePoint, startHeading, radius);
            }
            
            for(int i = 0; i < ballBotArray.length; i++){
                if(ballBotArray[i] != null){
                    
                }
            }
        }
    }
}