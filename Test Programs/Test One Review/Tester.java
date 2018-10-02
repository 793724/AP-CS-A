public class Tester {
    public static void main() {
       System.out.print("Print a random number between 1 and 15: ");
       System.out.println((int)(Math.random()*10+5));
       
       System.out.println("While loop loading an array with even #s 2 to 20");
       int[] nums = new int[10];
       int i = 0;
       int evenCount = 2;
       while(i < nums.length){
           nums[i] = evenCount;
           evenCount += 2;
           System.out.print(nums[i] + ", ");
           i += 1;
       }
    }
    
    public int[] maxEnd3(int[] nums) {
        int i = 0;
        if(nums[0] >= nums[nums.length - 1]){
            i = nums[0];
        } else {
            i = nums[nums.length - 1];
        }
        for(int j = 0; j < nums.length; j++) {
            nums[j] = i;
            System.out.print(nums[j] + ", ");
        }
        return nums;
    }
}