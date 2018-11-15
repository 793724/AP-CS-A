import java.util.ArrayList;
/**
 * ArrayList Project 2- Student List
 *
 * @author (Emma Chiu)
 * @version (1025)
 */

public class StudList{
    ArrayList<Student> studList = new ArrayList<Student>(); // creates new student array list
    
    public void addStudentToList(String name, int number, double gpa) {
        // initializes new student and adds it to the list
        Student s = new Student();
        parseUserInput(s, name);
        s.setStuNumber(number);
        s.setGPA(gpa);
        studList.add(s);
    }
    
    public boolean deleteStudentFromList(String last){
        boolean deleted = false; // if the student has been deleted
        for(int i = 0; i < studList.size(); i++) { // runs through the list
            if(studList.get(i).getLastName().equals(last)) { // sees if the element has a matching last name
                studList.remove(i); // removes the student
                deleted = true; // indicates it's been removed
            }
        }
        return deleted;
    }
    
    public boolean editStudentList(int number, String last, String name, double gpa) {
        boolean edited = false; // if the student has been edited
        if(number != 0) {
            for(int i = 0; i < studList.size(); i++) { // runs through the list
                if(studList.get(i).getStuNumber() == number) { // sees if the element has a matching student number
                    // if so, updates student information
                    Student student = new Student();
                    parseUserInput(student, name);
                    student.setStuNumber(number);
                    student.setGPA(gpa);
                    studList.set(i, student);
                    edited = true; // indicates it's been edited
                }
            }
        } else {
            for(int i = 0; i < studList.size(); i++) { // runs through the list
                if(studList.get(i).getLastName().equals(last)) { // sees if the element has a matching last name
                    // if so, updates student information
                    Student student = new Student();
                    parseUserInput(student, name);
                    student.setStuNumber(studList.get(i).getStuNumber());
                    student.setGPA(gpa);
                    studList.set(i, student);
                    edited = true; // indicates it's been edited
                }
            }
        }
        return edited;
    }
    
    public void clearList() {
        studList.clear(); // simple array list method; removes all students
    }
    
    public void printStudentList() {
        if(studList.size() > 0) {
            for(int i = 0; i < studList.size(); i++) { // runs through the list
               // prints the info of each student
               System.out.println(i+1 + ". Name: " + studList.get(i).getStudentName() + ", Student Number: " + studList.get(i).getStuNumber() + ", GPA: " + studList.get(i).getGPA());
           }
        } else {
            System.out.println("There are no students in your list!"); // if the list is empty
        }
    }
    
    public Student printStudent(int number, String last) {
        for(int i = 0; i < studList.size(); i++) { // runs through the list
            if(number != 0) {
                if(studList.get(i).getStuNumber() == number) { // sees if the element has a matching student number
                    // if so, returns the student at that element
                    return studList.get(i);
                }
            } else {
                if(studList.get(i).getLastName().equals(last)) { // sees if the element has a matching last name
                    // if so, returns the student at that element
                    return studList.get(i);
                }
            }
        }
        return null; // if the student doesn't exist
    }
    
    public void parseUserInput(Student s, String name) {
        // instance variables to make things shorter 
        int comma = name.indexOf(",");
        int space = name.indexOf(" ");
        if(comma != -1 && findSpace(name) == 2) { // in the format of last, first middle
            // set the name using substrings
            s.setFirstName(name.substring(comma + 2, name.indexOf(" ", comma + 2)));
            s.setMiddleName(name.substring(name.indexOf(" ", comma + 2) + 1));
            s.setLastName(name.substring(0, comma));
        } else if(comma == -1 && (findSpace(name) == 2)) { // in the format of first middle last
            // set the name using substrings
            s.setFirstName(name.substring(0, space));
            s.setMiddleName(name.substring(space + 1, name.indexOf(" ", space + 1)));
            s.setLastName(name.substring(name.indexOf(" ", space + 1) + 1));
        } else if(comma == -1) { // in the format of first last
            // set the name using substrings
            s.setFirstName(name.substring(0, space));
            s.setMiddleName("");
            s.setLastName(name.substring(name.indexOf(" ") + 1));
        }
    }
    
    public int findSpace(String name) {
        String editName = name.toLowerCase().trim(); // removes unnecessary spaces
        int count = 0; // how many times a space has appeared
        for(int i = 0; i < editName.length() - 1; i++) { // runs through list
            if(editName.substring(i, i + 1).equals(" ")) {
                count++; // adds one to the count each time a space appeared
            }
        }
        if(editName.substring(editName.length() - 1).equals(editName)) {
            count++; // final index
        }
        return count;
    }
}