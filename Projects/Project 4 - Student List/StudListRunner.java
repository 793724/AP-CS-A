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
                if((name.indexOf(",") != -1 && name.indexOf(" ") != -1 && name.indexOf(" ", name.indexOf(" ")) != -1) || (name.indexOf(",") == -1 && name.indexOf(" ") != -1)) {
                    System.out.print("Enter your student's student number: ");
                    int number = command1.nextInt();
                    if(countDigits(number) == 6) {
                        System.out.print("Enter your student's GPA: ");
                        double gpa = command1.nextDouble();
                        studList.addStudentToList(name, number, gpa);
                        System.out.println("Your student has been added!");
                    } else {
                        invalid();
                    }
                } else {
                    invalid();
                }
                System.out.println();
            } else if (command == 2) {
                Scanner command2 = new Scanner(System.in);
                System.out.print("Enter your student's last name: ");
                String name = command2.nextLine();
                if(studList.deleteStudentFromList(name) == true) {
                    System.out.println("Your student has been removed!");
                } else {
                    System.out.println("Sorry, this student was not in the list.");
                }
                System.out.println();
            } else if (command == 3) {
                Scanner command3 = new Scanner(System.in);
                System.out.println("Would you like to search for your student:");
                System.out.println("  - by student number (press 1), or");
                System.out.println("  - by last name (press 2)?");
                int choice = command3.nextInt();
                if (choice == 1) {
                    Scanner command32 = new Scanner(System.in);
                    System.out.print("Enter your student's student number: ");
                    int number = command32.nextInt();
                    if(countDigits(number) == 6) {
                        Scanner command33 = new Scanner(System.in);
                        System.out.print("Enter your student's updated name: ");
                        String name = command33.nextLine();
                        if((name.indexOf(",") != -1 && name.indexOf(" ") != -1 && name.indexOf(" ", name.indexOf(" ")) != -1) || (name.indexOf(",") == -1 && name.indexOf(" ") != -1)) {
                            System.out.print("Enter your student's updated GPA: ");
                            double gpa = command33.nextDouble();
                            String last = null;
                            if(studList.editStudentList(number, last, name, gpa) == true) {
                                System.out.println("Your student has been edited!");
                            } else {
                                System.out.println("Sorry, this student was not in the list.");
                            }
                        } else {
                            invalid();
                        }
                    } else {
                        invalid();
                    }
                } else if (choice == 2) {
                    Scanner command32 = new Scanner(System.in);
                    System.out.print("Enter your student's last name: ");
                    String last = command32.nextLine();
                    Scanner command33 = new Scanner(System.in);
                    System.out.print("Enter your student's updated name: ");
                    String name = command33.nextLine();
                    System.out.print("Enter your student's updated GPA: ");
                    double gpa = command33.nextDouble();
                    int number = 0;
                    if(studList.editStudentList(number, last, name, gpa) == true) {
                        System.out.println("Your student has been edited!");
                    } else {
                        System.out.println("Sorry, this student was not in the list.");
                    }
                } else {
                    invalid();
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
            } else if (command == 6) {
                Scanner command6 = new Scanner(System.in);
                System.out.println("Would you like to search for your student:");
                System.out.println("  - by student number (press 1), or");
                System.out.println("  - by last name (press 2)?");
                int choice = command6.nextInt();
                if (choice == 1) {
                    Scanner command61 = new Scanner(System.in);
                    System.out.print("Enter your student's student number: ");
                    int number = command61.nextInt();
                    if(countDigits(number) == 6) {
                        Student printed = studList.printStudent(number, "");
                        if(printed != null) {
                            System.out.println("Your student is as follows. Name: " + printed.getStudentName() + ", Student Number: " + printed.getStuNumber() + ", GPA: " + printed.getGPA());
                        } else {
                            System.out.println("Sorry, this student was not in the list.");
                        }
                    } else {
                        invalid();
                    }
                } else if (choice == 2) {
                    Scanner command62 = new Scanner(System.in);
                    System.out.print("Enter your student's last name: ");
                    String last = command62.nextLine();
                    Student printed = studList.printStudent(0, last);
                    if(printed != null) {
                        System.out.println("Your student is as follows. Name: " + printed.getStudentName() + ", Student Number: " + printed.getStuNumber() + ", GPA: " + printed.getGPA());
                    } else {
                        System.out.println("Sorry, this student was not in the list.");
                    }
                } else {
                    invalid();
                }
                System.out.println();
            } else {
                invalid();
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
    
    public static int countDigits(int input) {
        int number = input;
        int count = 0;
        while(number > 0){
            number = number / 10;
            count += 1;
        }
        return count;
    }
    
    public static void invalid() {
        System.out.println("Sorry, that was an invalid input. Please try again.");
    }
}