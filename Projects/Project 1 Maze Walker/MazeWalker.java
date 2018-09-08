
/**
 * MazeWalker
 * 
 * @author (Emma Chiu) 
 * @version (830)
 */

public class MazeWalker{
    
    /**
    
    public void setBreadCrumbObject(Object breadCrumbObject){
        breadCrumb() = breadCrumbObject;
    }
    
    public Object getBreadCrumbObject(){
        return breadCrumb();
    }
    
    */
    
    public static void run(){
        Maze maze = new Maze(1);
        MazeWalker mazeWalker = new MazeWalker();
        mazeWalker.walkMaze(maze, maze.getMazeBot());
    }
    
    public void walkMaze(Maze maze, MazeBot mazeBot){
        while(mazeBot.didNotReachGoal() == true){
            if(mazeBot.canMoveForward() == false){
                mazeBot.turnRight();
                if(mazeBot.canMoveForward() == false){
                    mazeBot.turnLeft();
                    mazeBot.turnLeft();
                }
            } else {
                while(mazeBot.canMoveForward()){
                    mazeBot.moveForward();
                }
            }
        }
        
        mazeBot.signalSuccess();
    }
}
