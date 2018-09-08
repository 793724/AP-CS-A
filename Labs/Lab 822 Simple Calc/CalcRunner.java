
/**
 * Lab816 First Class
 *
 * @author (echiu)
 * @version (816)
 */

import java.util.Scanner;

public class CalcRunner{
    public static void main(){
        Scanner reader = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter an integer: ");
        int n1 = reader.nextInt();
        System.out.println("Enter another integer: ");
        int n2 = reader.nextInt();
        reader.close();
        SimpleCalc calculation = new SimpleCalc();
        System.out.println();
        System.out.println("Your calculations are as follows:");
        System.out.println(n1 + " + " + n2 + " = " + calculation.add(n1, n2));
        System.out.println(n1 + " - " + n2 + " = " + calculation.subtract(n1, n2));
        System.out.println(n1 + " * " + n2 + " = " + calculation.multiply(n1, n2));
        System.out.println(n1 + " / " + n2 + " = " + calculation.divide(n1, n2));
        System.out.println(n1 + " % " + n2 + " = " + calculation.moduloDivide(n1, n2));
        /**
         * If you try to divide by 0 you'll get 0.
         */
    }
}