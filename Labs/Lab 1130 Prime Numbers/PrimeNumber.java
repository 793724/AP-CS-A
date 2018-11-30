import java.util.ArrayList;
/**
 * Lab 1130 Prime Numbers
 *
 * @ Emma Chiu
 * @ 1130
 */

public class PrimeNumber {
    // Initializes array list
    private ArrayList<Integer> numbers;

    // Constructor
    public PrimeNumber() {
        numbers = new ArrayList<Integer>();
    }

    // Methods
        // Sets the array list to a given integer input
    public void setListToNumber(int n) {
        System.out.println("You have inputted the integer " + n + ".");
        while(n > 0) {
            numbers.add(0, n % 10);
            n = n / 10;
        }
        printList();
    }
    
        // Adds a given integer to the array list
    public void addNumberToList(int n) {
        System.out.println("You have added the integer " + n + " to your list.");
        for(int i = 0; i < numbers.size(); i++) {
            if(n > 0) {
                int reverseSpot = numbers.size() - 1 - i;
                numbers.set(reverseSpot, numbers.get(reverseSpot) + n % 10);
                n = n / 10;
            }
        }
        printList();
    }
    
        // Adds together the numbers in two array lists
    public void addNumbers(ArrayList<Integer> n1, ArrayList<Integer> n2) {
    }
    
        // Extra method: prints the array list
    public void printList() {
        System.out.print("Your list is as follows: ");
        for(int i = 0; i < numbers.size() - 1; i++) {
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.print(numbers.get(numbers.size() - 1));
        System.out.println();
    }
}
