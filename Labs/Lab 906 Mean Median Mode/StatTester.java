
/**
 * StatTester finds loads an Array of int
 * and finds the sum, mean, median, and mode.
 * 
 * @author (Emma Chiu) 
 * @version (906)
 * 
 * TO FIX:
 * Mean returns a double but the division itself is integer, so it's always .0
 * Only returns one of multiple modes
 * 
 */

// imports go here
import java.util.Arrays;

public class StatTester{
    //  Instance variables
    private int[] nums;
    
    // Constructor
    public StatTester(){
        nums = new int[100];
    }
    
    
    //  Methods
    public void loadArray(){
        for(int i = 0; i < nums.length; i++){
              nums[i] = (int)(Math.random()*10+1);
        }
    }
    
    public void printArray(){
        for(int i = 0; i < nums.length-1; i++){
            System.out.print(nums[i] + ", ");
            if((i+1)%10 == 0){
                System.out.println();
            }
        }
        System.out.print(nums[nums.length-1]);
    }
    
    public void sortArray(){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++){
            System.out.print(nums[i] + ", ");
            if((i+1)%10 == 0){
                System.out.println();
            }
        }
        System.out.print(nums[nums.length-1]);
    }
    
    public int getSum(){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        return sum;
    }
    
    public double getMean(){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        return sum/nums.length;
    }
    
    public double getMedian(){
        if(nums.length % 2 == 0){
            return nums[((nums.length/2)+(nums.length/2-1))/2];
        } else {
            return nums[(nums.length-1)/2];
        }
    }
    
    public int getMode(){
        int current = nums[0];
        int tempCount = 0;
        int storeCount = 0;
        int storeValue = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == current){
                tempCount = tempCount + 1;
            } else {
                if(tempCount >= storeCount){
                    storeCount = tempCount;
                    storeValue = nums[i-1];
                }
                tempCount = 1;
            }
            current = nums[i];
        }
        return storeValue;
    }
}