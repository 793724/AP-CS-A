
/**
 * ArrayList Project 2- Student List
 *
 * @author (Emma Chiu)
 * @version (1025)
 */

public class Student {
    private String firstName;
    private String middleName;
    private String lastName;
    private int stuNumber;
    private double gpa;
    
    public void setFirstName(String first) {
        firstName = first;
    }
    
    public void setMiddleName(String middle) {
        middleName = middle;
    }
    
    public void setLastName(String last) {
        lastName = last;
    }
    
    public void setStuNumber(int number) {
        stuNumber = number;
    }
    
    public void setGPA(double stuGpa) {
        gpa = stuGpa;
    }
    
    public String getFirstName() { // temporary method in place of getStudentName
        return firstName;          // while only first name is accepted
    }
    
    public String getStudentName() {
        return lastName + ", " + firstName + " " + middleName;
    }
    
    public double getGPA() {
        return gpa;
    }
    
    public int getStuNumber() {
        return stuNumber;
    }
    
}
