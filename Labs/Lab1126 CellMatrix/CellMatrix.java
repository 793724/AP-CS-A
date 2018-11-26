import java.util.Random;
/**
 * 
 * CellMatrix
 * @author (eettlin) 
 * @version (11-26-18)
 */
public class CellMatrix{
    /**
     * +++++++++++++++++++++Instance variables
     */

    private Cell[][] cells;

    /**
     * +++++++++++++++++++++Constructor for objects of class NumberMatrix
     */
    public CellMatrix(int a, int b){
        cells = new Cell[a][b];
    }

    /**
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++methods
     */
    //Print each row and column of nums to the console
    public void printMatrix(){
        // runs through the matrix
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                // prints values at each of the indices
                System.out.print(cells[row][col].getInt() + " " );
            }
            System.out.println();
        }
        System.out.println();
    }

    //  load nums with random with numbers between 1 and 10 inclusive
    public void loadMatrix(){
        // runs through the matrix
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                // creates a new cell object at that index and sets it to a random number
                cells[row][col] = new Cell((int)(Math.random() * 10 + 1));
            }
        }
    }

    //  Finds the sum of each of the neighbors and returns the greatest 
    // neighbor value
    public int getGreatestNeighbors(){
        // instance variables
        int greatest = 0;
        int neighborSum;
        
        // runs through matrix
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                // loads the neighbors array
                loadNeighbors(cells[row][col], row, col);
                neighborSum = 0;
                Cell[] current = cells[row][col].getNeighbors();
                // runs through the neighbors array
                for (int i = 0; i < current.length; i++) {
                    // finds the sum of the neighbors
                    neighborSum = neighborSum + current[i].getInt();
                }
                if(neighborSum >= greatest) {
                    // updates greatest value if applicable
                    greatest = neighborSum;
                }
            }
        }
        return greatest;
    }

    //  Load neighbor cells into the neighbors array
    public void loadNeighbors(Cell c, int row, int col){
        // instance variables
        int north;
        int east;
        int south;
        int west;
        if(row == 0) { // initializes north
            north = 0;
        } else {
            north = cells[row - 1][col].getInt();
        }
        if(row == cells.length - 1) { // initializes south
            south = 0;
        } else {
            south = cells[row + 1][col].getInt();
        }
        if(col == 0) { // initializes west
            west = 0;
        } else {
            west = cells[row][col - 1].getInt();
        }
        if(col == cells[0].length - 1) { // initializes east
            east = 0;
        } else {
            east = cells[row][col + 1].getInt();
        }
        
        // adds neighbors to matrix
        c.setNeighbors(0, north);
        c.setNeighbors(1, east);
        c.setNeighbors(2, south);
        c.setNeighbors(3, west);
    }
}
