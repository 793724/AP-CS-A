
/**
 * Write a description of class Numbers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Numbers {
    public static void main(){
        int i = 1002;
        int count = 0;
        while(i > 0){
            i = i / 10;
            System.out.println(i);
            count += 1;
        }
        System.out.println("Total Digits: " + count);
        System.out.println();
        System.out.println();
        
        int j = 1002;
        int sum = 0;
        while(j > 0){
            sum = sum + (j % 10);
            System.out.println(j);
            j = j / 10;
        }
        System.out.println("Sum of Digits: " + sum);
        System.out.println();
        System.out.println();
        
        for(int loop = 0; loop < 10; loop++) {
            System.out.print((int)(Math.random()*10 + 1) + ", ");
        }
    }
}
