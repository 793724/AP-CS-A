import java.util.Scanner;
/**
 * ArrayList Project 2- Student List
 *
 * @author (Emma Chiu)
 * @version (1025)
 */

public class StudListRunner{
    public static void main() {
        boolean end = false;
        StudList studList = new StudList();
        Scanner scr = new Scanner(System.in);
        while(end == false) {
            int command = menuNumber();
            if(command == 7) {
                end = true;
            } else if (command == 1) {
                System.out.println("What is the first name of the student you would like to add (note: middle and last names not yet available)?");
                String name = scr.nextLine();
                System.out.println("What is your student's student number?");
                int number = scr.nextInt();
                System.out.println("What is your student's GPA?");
                double gpa = scr.nextDouble();
                studList.addStudentToList(name, number, gpa);
                
                System.out.println("Your student has been added!");
                System.out.println();
            } else if (command == 5) {
                System.out.println("Your list of students is as follows:");
                studList.printStudentList();
                System.out.println();
            } else if (command <= 7 && command >= 1){
                System.out.println("Unfortunately, this command has not yet been implemented.");
                System.out.println();
            } else {
                System.out.println("Invalid input. Please try again.");
            }
            System.out.println("Press any key to clear the screen and continue!");
            
        }
    }
    
    public static int menuNumber() {
        Scanner scr = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("  - Add a student (1)");
        System.out.println("  - Delete a student (2)");
        System.out.println("  - Edit a student's information (3)");
        System.out.println("  - Clear the list of students (4)");
        System.out.println("  - Print the list of students (5)");
        System.out.println("  - Print a student's information (6)");
        System.out.println("  - End the program (7)");
        int input = scr.nextInt();
        return input;
    }
}