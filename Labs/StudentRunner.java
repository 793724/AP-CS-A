/**
 * Lab 912 Student Array
 *
 * @author (Emma Chiu)
 * @version (912)
 */
public class StudentRunner{
    public static void main(){
        // Array of student names
        String[] names = {"Ajax", "Bellerophon", "Cassandra", "Daedalus", "Elpis"};
        
        // Array of student numbers
        int[] stuNums = {719374, 748247, 750184, 769702, 759204};
        
        // Combine names and numbers to make students
        Student[] Students = new Student[5];
        for(int i = 0; i < Students.length; i++) {
            Students[i] = new Student(names[i], stuNums[i]);
        }
    }
    
}