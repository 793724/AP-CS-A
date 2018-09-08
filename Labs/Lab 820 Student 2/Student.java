
/**
 * Lab820 Student2
 *
 * @author (echiu)
 * @version (820)
 */
public class Student{
    /**
     * Instance variables of class Student
     */
    private int studNumber;
    private boolean stuActive;
    private double stuGPA;
    private String stuName;

    /**
     * Constructor for objects of class Student
     */
    public Student(){
        // initialise instance variables
        studNumber = 0;
        stuActive = true;
        stuGPA = 0.0;
        stuName = "Person";
    }

    /**
     * Student Methods
     */
    public void setStudNumber(int sn){
        // put your code here
        studNumber = sn;
    }
    public int getStudNumber() {
        return studNumber;
    }
    public void setStuActive(boolean sn){
        // put your code here
        stuActive = sn;
    }
    public boolean getStuActive() {
        return stuActive;
    }
    public void setStuGPA(double sn){
        // put your code here
        stuGPA = sn;
    }
    public double getStuGPA() {
        return stuGPA;
    }
    public void setStuName(String sn){
        // put your code here
        stuName = sn;
    }
    public String getStuName() {
        return stuName;
    }
}
