import java.util.ArrayList;
/**
 * ArrayList Project 2- Student List
 *
 * @author (Emma Chiu)
 * @version (1025)
 */

public class StudList{
    ArrayList<Student> studList = new ArrayList<Student>();
    
    public ArrayList addStudentToList(String name, int number, double gpa) {
        Student s = new Student();
        s.setFirstName(name);
        s.setStuNumber(number);
        s.setGPA(gpa);
        studList.add(s);
        return studList;
    }
    
    public void printStudentList() {
        for(int i = 0; i < studList.size(); i++) {
            System.out.println(i+1 + ". Name: " + studList.get(i).getFirstName() + ", Student Number: " + studList.get(i).getStuNumber() + ", GPA: " + studList.get(i).getGPA());
        }
    }
}