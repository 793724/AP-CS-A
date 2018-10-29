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
        s.setFirstName(name);
        s.setMiddleName(name);
        s.setLastName(name);
        s.setStuNumber(number);
        s.setGPA(gpa);
        studList.add(s);
    }
    
    public boolean deleteStudent(String last){
        boolean deleted = false;
        for(int i = 0; i < studList.size(); i++) {
            if(studList.get(i).getLastName().equals(last)) {
                studList.remove(i);
                deleted = true;
            }
        }
        return deleted;
    }
    
    public boolean editStudentList(int number, String name, double gpa) {
        boolean edited = false;
        for(int i = 0; i < studList.size(); i++) {
            if(studList.get(i).getStuNumber() == number) {
                Student student = new Student();
                student.setFirstName(name);
                student.setMiddleName(name);
                student.setLastName(name);
                student.setGPA(gpa);
                studList.set(i, student);
                edited = true;
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
}