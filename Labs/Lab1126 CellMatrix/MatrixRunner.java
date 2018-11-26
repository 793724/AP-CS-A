
/**
 * 
 * 
 * @author (eettlin) 
 * @version (11-26-18)
 */
public class MatrixRunner{
    public static void main(){
        CellMatrix cm = new CellMatrix(3, 4); // new cell matrix created
        cm.loadMatrix(); // loads the matrix
        System.out.println("The matrix: ");
        cm.printMatrix(); // prints the matrix
        // prints the greatest neighbors
        System.out.println("Greatest neighbors: " + cm.getGreatestNeighbors());
    }
}
