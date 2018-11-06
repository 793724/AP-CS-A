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
        for(int r = 0; r < grid.length; r++){ // runs through array
            for(int c = 0; c < grid[r].length; c++) {
                grid[r][c] = (int)(Math.random() * 100 + 1); // sets element to a random int
            }
        }
    }
    
    public static int sumAll(int[][] grid) {
        int sum = 0; // sum of the elements in the array
        for(int r = 0; r < grid.length; r++){ // runs through array
            for(int c = 0; c < grid[r].length; c++) {
                sum = sum + grid[r][c]; // adds the element to the sum
            }
        }
        return sum;
    }
    
    public static int findGreatest(int[][] grid) {
        int greatest = grid[0][0]; // greatest element in the array
        for(int r = 0; r < grid.length; r++){ // runs through array
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] > greatest) {
                    greatest = grid[r][c]; // updates the greatest element if necessary
                }
            }
        }
        return greatest;
    }
    
    public static int numberOfGreatest(int[][] grid) {
        int greatest = grid[0][0]; // greatest element in the array
        int number = 0; // number of times that element occurs
        for(int r = 0; r < grid.length; r++){ // runs through array
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] > greatest) {
                    greatest = grid[r][c]; // updates the greatest element if necessary
                    number = 1; // resets number of occurrences to 1
                } else if(grid[r][c] == greatest) {
                    number++; // adds to the number of occurrences
                }
            }
        }
        return number;
    }
    
    public static double findAvg(int[][] grid) {
        int sum = 0; // sum of the elements in the array
        int elements = 0; // number of elements in the array
        for(int r = 0; r < grid.length; r++){ // runs through array
            for(int c = 0; c < grid[r].length; c++) {
                sum = sum + grid[r][c]; // adds the element to the sum
                elements++; // changes the number of elements by 1
            }
        }
        return (double)sum/(double)elements;
    }
}
