import java.util.ArrayList;
/**
 * Semester One Review
 *
 * @ Emma Chiu
 * @ 12/12/18
 */

public class FreeResponse {
    // Runs methods for FR3 and FR4
    public static void main() {
        // FR3
        String[] randStrings = {"yes", "no", "maybe", "perhaps", "It remains to be seen"};
        String response = getRandomResponse(randStrings);
        System.out.println("Free Response #3: " + response);
        
        // FR4
        int[][] nums = new int[10][10];
        int numEvens = loadNums(nums);
        System.out.println("Free Response #4: " + numEvens + " even numbers");
    }
    
    // FR1 - getter and setter for gpa
    private double GPA;
    
    public void setGPA(double gpa) {
        GPA = gpa;
    }

    public double getGPA() {
        return GPA;
    }

    // FR2 - sets all array list values outside of a specified bound to the min or max
    public int adjustMaxMin(ArrayList<Integer> levels, int maxLevel){
        int changedValues = 0;
        for(int i = 0; i < levels.size(); i++) {
            if(levels.get(i) > maxLevel) {
                levels.set(i, maxLevel);
                changedValues++;
            }
            if(levels.get(i) < (maxLevel*(-1))) {
                levels.set(i, maxLevel*(-1));
                changedValues++;
            }
        }
        return changedValues;
    }
    
    // FR3 - returns a random response
    public static String getRandomResponse(String[] str){
        int num = (int)(Math.random()*(str.length));
        String response = str[num];
        return response;
    }
    
    // FR4 - loads a 2D array with random values and returns the number of even values
    public static int loadNums(int[][] nums) {
        int evens = 0;
        for(int r = 0; r < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++) {
                nums[r][c] = (int)(Math.random()*10 + 1);
                if(nums[r][c] % 2 == 0) {
                    evens++;
                }
            }
        }
        return evens;
    }
}
