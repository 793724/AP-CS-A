/**
 * Test Two Review
 *
 * @ Emma Chiu
 * @ 1106
 */

public class Testers {
    public static void main() {
        System.out.println("Hi\nthere.");
        System.out.println();
        System.out.println("Hi\tthere.");
        System.out.println();
        System.out.println("Hi\\there.");
        System.out.println();
        System.out.println();
        
        for(int i = 3; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print(", " + j);
            }
            System.out.println();
        }
    }
}
