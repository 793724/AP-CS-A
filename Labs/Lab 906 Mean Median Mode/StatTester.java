
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
        nums = new int[100];
        mode = new int[11];
    }
    
    
    //  Methods
    public void loadArray(){
        for(int i = 0; i < nums.length; i++){
              nums[i] = (int)(Math.random()*10+1);
        }
        
        for(int z = 0; z < mode.length; z++){
              mode[z] = 0;
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
        double mean = ((double) sum / nums.length);
        return mean;
    }
    
    public double getMedian(){
        if(nums.length % 2 == 0){
            double median = ((double) (nums[nums.length/2]+nums[nums.length/2-1])/2);
            return median;
        } else {
            double median = ((double) nums[(nums.length-1)/2]);
            return median;
        }
    }
    
    public void getMode(){
        int prior = nums[0];
        int tempCount = 0;
        int storeCount = 0;
        int fillArray = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == prior){
                tempCount = tempCount + 1;
                if(i == nums.length - 1 && tempCount >= storeCount){
                    if(tempCount > storeCount){
                       storeCount = tempCount;
                       for(int z = 0; z < mode.length; z++){
                           mode[z] = 0;
                       }
                       fillArray = 0;
                    }
                    mode[fillArray] = nums[i-1];
                    fillArray++;
                }
            } else {
                if(tempCount >= storeCount){
                   if(tempCount > storeCount){
                       storeCount = tempCount;
                       for(int z = 0; z < mode.length; z++){
                           mode[z] = 0;
                       }
                       fillArray = 0;
                   }
                   mode[fillArray] = nums[i-1];
                   fillArray++;
                }
                tempCount = 1;
            }
            prior = nums[i];
        }
        
        for(int i = 0; mode[i] != 0; i++){
            System.out.print(mode[i]);
            if(mode[i+1] != 0){
                System.out.print(", ");
            }
        }
    }
}
