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
        while(end == false) {
            int command = menuNumber();
            if(command == 7) {
                end = true;
            } else if (command == 1) {
                Scanner command1 = new Scanner(System.in);
                System.out.print("Enter your student's name: ");
                String name = command1.nextLine();
                System.out.print("Enter your student's student number: ");
                int number = command1.nextInt();
                System.out.print("Enter your student's GPA: ");
                double gpa = command1.nextDouble();
                studList.addStudentToList(name, number, gpa);
                System.out.println("Your student has been added!");
                System.out.println();
            } else if (command == 2) {
                Scanner command2 = new Scanner(System.in);
                System.out.print("Enter your student's last name: ");
                String name = command2.nextLine();
                if(studList.deleteStudent(name) == true) {
                    System.out.println("Your student has been removed!");
                } else {
                    System.out.println("Sorry, this student was not in the list.");
                }
                System.out.println();
            } else if (command == 3) {
                Scanner command3 = new Scanner(System.in);
                System.out.print("Enter your student's student number: ");
                int number = command3.nextInt();
                System.out.print("Enter your student's updated name: ");
                String name = command3.nextLine();
                System.out.print("Enter your student's updated GPA: ");
                double gpa = command3.nextDouble();
                if(studList.editStudentList(number, name, gpa) == true) {
                    System.out.println("Your student has been edited!");
                } else {
                    System.out.println("Sorry, this student was not in the list.");
                }
                System.out.println();
            } else if (command == 4) {
                studList.clearList();
                System.out.println("Your list of students has been cleared.");
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
            if(command != 7) {
                Scanner clear = new Scanner(System.in);
                System.out.println("Press any key to clear the screen and continue!");
                String clearScreen = clear.nextLine();
                System.out.print('\u000C');
            } else {
                System.out.println("Thanks for using StudentList!");
            }
        }
    }
    
    public static int menuNumber() {
        Scanner takeCommand = new Scanner(System.in);
        System.out.println("What would you like to do? Choose a command:");
        System.out.println("  - Add a student (1)");
        System.out.println("  - Delete a student (2)");
        System.out.println("  - Edit a student's information (3)");
        System.out.println("  - Clear the list of students (4)");
        System.out.println("  - Print the list of students (5)");
        System.out.println("  - Print a student's information (6)");
        System.out.println("  - End the program (7)");
        System.out.println();
        int input = takeCommand.nextInt();
        return input;
    }
}