
/**
 * Project 2 - Ball Runner
 *
 * @author (Emma Chiu)
 * @version (914)
 */
public class BallRunner {
    public static void run() {
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint startPoint = new TGPoint(0, 0);
        BallBot ballBot = new BallBot(ballworld, startPoint, 0, 25);
    }
}
