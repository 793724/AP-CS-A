
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
    
    public void setFirstName(String name) {
        int comma = name.indexOf(",");
        int space = name.indexOf(" ");
        if(comma != -1 && findSpace(name) == 2) {
            firstName = name.substring(comma + 2, name.indexOf(" ", comma + 2));
        } else if(comma == -1 && (findSpace(name) == 2 || findSpace(name) == 1)) {
            firstName = name.substring(0, space);
        } else {
            firstName = null;
        }
    }
    
    public void setMiddleName(String name) {
        int comma = name.indexOf(",");
        int space = name.indexOf(" ");
        if(comma != -1 && findSpace(name) == 2) {
            middleName = name.substring(name.indexOf(" ", comma + 2) + 1);
        } else if(comma == -1 && findSpace(name) == 2) {
            middleName = name.substring(space + 1, name.indexOf(" ", space + 1));
        } else {
            middleName = null;
        }
    }
    
    public void setLastName(String name) {
        int comma = name.indexOf(",");
        int space = name.indexOf(" ");
        if(comma != -1 && findSpace(name) == 2) {
            lastName = name.substring(0, comma);
        } else if(comma == -1 && (findSpace(name) == 2 || findSpace(name) == 1)) {
            lastName = name.substring(name.indexOf(" ", space + 1) + 1);
        } else {
            lastName = null;
        }
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
    
    public int findSpace(String name) {
        String editName = name.toLowerCase();
        int count = 0;
        for(int i = 0; i < editName.length() - 1; i++) {
            if(editName.substring(i, i + 1).equals(" ")) {
                count++;
            }
        }
        if(editName.substring(editName.length() - 1).equals(editName)) {
            count++;
        }
        return count;
    }
}
