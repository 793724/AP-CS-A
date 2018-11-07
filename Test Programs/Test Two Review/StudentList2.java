/**
 * Test Two Review
 *
 * @ Emma Chiu
 * @ 1106
 */

public class StudentList2 {
    public void parseName(String name, Student s) {
        int space = name.indexOf(" ");
        s.setFirstName(name.substring(0, space));
        s.setMiddleName(name.substring(space + 1, name.indexOf(" ", space + 1)));
        s.setLastName(name.substring(name.indexOf(" ", space + 1) + 1));
    }
}
