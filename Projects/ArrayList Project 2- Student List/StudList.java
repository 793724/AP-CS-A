import java.util.ArrayList;
/**
 * ArrayList Project 2- Student List
 *
 * @author (Emma Chiu)
 * @version (1025)
 */

public class StudList{
    ArrayList<Student> studList = new ArrayList<Student>();
    
    public void addStudentToList(String name, int number, double gpa) {
        Student s = new Student();
        parseUserInput(s, name);
        s.setStuNumber(number);
        s.setGPA(gpa);
        studList.add(s);
    }
    
    public boolean deleteStudentFromList(String last){
        boolean deleted = false;
        for(int i = 0; i < studList.size(); i++) {
            if(studList.get(i).getLastName().equals(last)) {
                studList.remove(i);
                deleted = true;
            }
        }
        return deleted;
    }
    
    public boolean editStudentList(int number, String last, String name, double gpa) {
        boolean edited = false;
        for(int i = 0; i < studList.size(); i++) {
            if(number != 0) {
                if(studList.get(i).getStuNumber() == number) {
                    Student student = new Student();
                    parseUserInput(student, name);
                    student.setStuNumber(number);
                    student.setGPA(gpa);
                    studList.set(i, student);
                    edited = true;
                }
            } else {
                if(studList.get(i).getLastName() == last) {
                    Student student = new Student();
                    parseUserInput(student, name);
                    student.setStuNumber(studList.get(i).getStuNumber());
                    student.setGPA(gpa);
                    studList.set(i, student);
                    edited = true;
                }
            }
        }
        return edited;
    }
    
    public void clearList() {
        studList.clear();
    }
    
    public void printStudentList() {
        if(studList.size() > 0) {
            for(int i = 0; i < studList.size(); i++) {
            System.out.println(i+1 + ". Name: " + studList.get(i).getStudentName() + ", Student Number: " + studList.get(i).getStuNumber() + ", GPA: " + studList.get(i).getGPA());
           }
        } else {
            System.out.println("There are no students in your list!");
        }
    }
    
    public Student printStudent(int number, String last, String name, double gpa) {
        for(int i = 0; i < studList.size(); i++) {
            if(number != 0) {
                if(studList.get(i).getStuNumber() == number) {
                    return studList.get(i);
                }
            } else {
                if(studList.get(i).getLastName() == last) {
                    return studList.get(i);
                }
            }
        }
        return null;
    }
    
    public void parseUserInput(Student s, String name) {
        int comma = name.indexOf(",");
        int space = name.indexOf(" ");
        if(comma != -1 && findSpace(name) == 2) {
             s.setFirstName(name.substring(comma + 2, name.indexOf(" ", comma + 2)));
             s.setMiddleName(name.substring(name.indexOf(" ", comma + 2) + 1));
             s.setLastName(name.substring(0, comma));
        } else if(comma == -1 && (findSpace(name) == 2)) {
            s.setFirstName(name.substring(0, space));
            s.setMiddleName(name.substring(space + 1, name.indexOf(" ", space + 1)));
            s.setLastName(name.substring(name.indexOf(" ", space + 1) + 1));
        } else if(comma == -1) {
            s.setFirstName(name.substring(0, space));
            s.setMiddleName("");
            s.setLastName(name.substring(name.indexOf(" ") + 1));
        }
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