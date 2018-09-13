
/**
 * StatTester finds loads an Array of int
 * and finds the sum, mean, median, and mode.
 * 
 * @author (Emma Chiu) 
 * @version (906)
 *
 */

// imports go here
import java.util.Arrays;

public class StatTester{
    //  Instance variables
    private int[] nums;
    private int[] mode;
    
    // Constructor
    public StatTester(){
        // initialize two arrays; one for nums and one for the mode
        nums = new int[100];
        mode = new int[11];
    }
    
    
    //  Methods
    public void loadArray(){
        // sets each element of nums to a random integer from 1 to 10
        for(int i = 0; i < nums.length; i++){
              nums[i] = (int)(Math.random()*10+1);
        }
        // sets each element of mode to 0
        for(int z = 0; z < mode.length; z++){
              mode[z] = 0;
        }
    }
    
    public void printArray(){
        // traverses the array and prints each element
        for(int i = 0; i < nums.length-1; i++){
            System.out.print(nums[i] + ", ");
            // line break every 10 numbers
            if((i+1)%10 == 0){
                System.out.println();
            }
        }
        // prints the final element
        System.out.print(nums[nums.length-1]);
    }
    
    public void sortArray(){
        // sorts the array in ascending order
        Arrays.sort(nums);
        // prints the sorted array
        for(int i = 0; i < nums.length-1; i++){
            System.out.print(nums[i] + ", ");
            if((i+1)%10 == 0){
                System.out.println();
            }
        }
        System.out.print(nums[nums.length-1]);
    }
    
    public int getSum(){
        // initializes sum variable
        int sum = 0;
        // traverses array, adding each element to the sum
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        return sum;
    }
    
    public double getMean(){
        // initializes sum variable
        int sum = 0;
        // finds sum
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        // divides sum by the number of elements
        double mean = ((double) sum / nums.length);
        return mean;
    }
    
    public double getMedian(){
        // finds middle number if array length is odd; average of two middles if even
        if(nums.length % 2 == 0){
            double median = ((double) (nums[nums.length/2]+nums[nums.length/2-1])/2);
            return median;
        } else {
            double median = ((double) nums[(nums.length-1)/2]);
            return median;
        }
    }
    
    public void getMode(){
        // initializes variables
        int prior = nums[0]; // previous element
        int tempCount = 0; // temporary digit count
        int storeCount = 0; // highest digit count thus far
        int fillArray = 0; // index of mode array
        // traverse array
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == prior){
                // changes temp count by one each time a number is repeated
                tempCount = tempCount + 1;
                if(i == nums.length - 1 && tempCount >= storeCount){
                    if(tempCount > storeCount){
                       // sets a record temp count to the store count
                       storeCount = tempCount;
                       // clears mode array
                       for(int z = 0; z < mode.length; z++){
                           mode[z] = 0;
                       }
                       fillArray = 0;
                    }
                    // adds new value to the mode array
                    mode[fillArray] = nums[i-1];
                    fillArray++;
                }
            } else {
                if(tempCount >= storeCount){
                   if(tempCount > storeCount){
                       // sets record temp count to store count
                       storeCount = tempCount;
                       // clears mode array
                       for(int z = 0; z < mode.length; z++){
                           mode[z] = 0;
                       }
                       fillArray = 0;
                   }
                   // adds new mode to mode array
                   mode[fillArray] = nums[i-1];
                   fillArray++;
                }
                // resets temp count
                tempCount = 1;
            }
            // updates value of prior element
            prior = nums[i];
        }
        // prints out mode array, stopping when it reaches 0
        for(int i = 0; mode[i] != 0; i++){
            System.out.print(mode[i]);
            if(mode[i+1] != 0){
                System.out.print(", ");
            }
        }
    }
}
