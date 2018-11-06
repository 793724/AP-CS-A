/**
 * Lab 1106 GridTester
 *
 * @ Emma Chiu
 * @ 1106
 */

public class GridTester {
    public static void main() {
        int[][] mat = new int[10][10];
        loadArray(mat);
        System.out.println("Your 10x10 array is loaded with random integers!");
        System.out.println("The sum of your array is " + sumAll(mat) + ".");
        System.out.println("The greatest number in your array is " + findGreatest(mat) + ".");
        System.out.println("This value occurs " + numberOfGreatest(mat) + " time(s).");
        System.out.println("The average of your array is " + findAvg(mat) + ".");
    }
    
    public static void loadArray(int[][] grid) {
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++) {
                grid[r][c] = (int)(Math.random() * 100 + 1);
            }
        }
    }
    
    public static int sumAll(int[][] grid) {
        int sum = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++) {
                sum = sum + grid[r][c];
            }
        }
        return sum;
    }
    
    public static int findGreatest(int[][] grid) {
        int greatest = grid[0][0];
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] > greatest) {
                    greatest = grid[r][c];
                }
            }
        }
        return greatest;
    }
    
    public static int numberOfGreatest(int[][] grid) {
        int greatest = grid[0][0];
        int number = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] > greatest) {
                    greatest = grid[r][c];
                    number = 1;
                } else if(grid[r][c] == greatest) {
                    number++;
                }
            }
        }
        return number;
    }
    
    public static double findAvg(int[][] grid) {
        int sum = 0;
        int elements = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++) {
                sum = sum + grid[r][c];
                elements++;
            }
        }
        return (double)sum/(double)elements;
    }
}
