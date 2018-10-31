
/**
 * ArrayList Project 2- Student List
 *
 * @author (Emma Chiu)
 * @version (1025)
 */

public class Student {
    String firstName;
    String middleName;
    String lastName;
    int stuNumber;
    double gpa;
    
    public void setFirstName(String name) {
        firstName = name;
    }
    
    public void setMiddleName(String name) {
        middleName = name;
    }
    
    public void setLastName(String name) {
        lastName = name;
    }
    
    public void setStuNumber(int number) {
        stuNumber = number;
    }
    
    public void setGPA(double stuGpa) {
        gpa = stuGpa;
    }
    
    public String getStudentName() {
        return lastName + ", " + firstName + " " + middleName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public double getGPA() {
        return gpa;
    }
    
    public int getStuNumber() {
        return stuNumber;
    }
}
