/**
 * Homework 1023
 *
 * @ Emma Chiu
 * @ 1023
 */

public class MultipleChoice {
    public static void main() {
        System.out.println("Multiple Choice #1:");
        System.out.println(go(-9)); // returns "done"
        
        System.out.println();
        System.out.println("Multiple Choice #2:");
        String str = "199 Churchill Ave. Woodside CA, 94062";
        // str.substring("Church"); returns an error since substring can't take in strings
        // str.substring(" "); returns an error since substring can't take in strings
        System.out.println(str.indexOf("Bananas")); // returns -1
        System.out.println(str.substring(str.indexOf("4"))); // returns "4062"
        System.out.println(str.substring(str.indexOf("CA"))); // returns "CA, 94062"
        System.out.println(str.substring(str.indexOf("W"), str.indexOf("W") + 9)); // returns "Woodside "
        System.out.println(str.indexOf(str.substring(2, 4) + 1)); // returns -1
        // String str2 = str.substring(indexOf("Woodside")); returns an error since there's no "str." before the indexOf method
        // System.out.println(str.substring(indexOf(" "))); returns an error for the same reason as the above line
        String str2 = str.substring(str.indexOf("Woodside"));
        System.out.println(str2.substring(str2.indexOf(" "))); // with the str2. added, this returns " CA, 94062"
    
        System.out.println();
        System.out.println("Multiple Choice #3:");
        for(int i = 3; i > 0; i--) {
            for(int j = 3; j >= i; j--) {
                System.out.print(", " + i*j);
            }
            System.out.println();
        }
        // with the "system." part added (wasn't there before), the code runs and prints ", 9" line break ", 6, 4" line break ", 3, 2, 1"
    }
    
    // Related code for Multiple Choice #1
    public static String go(int x) {
        if(x == 5) { // code originally missed this set of brackets; wouldn't run without them
            return "same";
        } else if (x > 5) {
            return "notsame";
        }
        return "done";
    }
}