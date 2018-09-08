
/**
 * Write a description of class SimpleCalc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SimpleCalc
{
    // instance variables - replace the example below with your own
    private int numOne;
    private int numTwo;

    /**
     * Constructor for objects of class CalcRunner
     */
    public SimpleCalc()
    {
        // initialises the two numbers
        numOne = 40;
        numTwo = 0;
    }

    /**
     * Method
     */
    public void setTwoNums(int x, int y){
        // sets parameters for the two numbers
        numOne = x;
        numTwo = y;
    }
    public double add(int numOne, int numTwo) {
        return numOne + numTwo;
    }
    public double subtract(int numOne, int numTwo) {
        return numOne - numTwo;
    }
    public double multiply(int numOne, int numTwo) {
        return numOne * numTwo;
    }
    public double divide(int numOne, int numTwo) {
        if(numTwo != 0){
            return numOne / numTwo;
        } else {
            return 0;
        }
    }
    public double moduloDivide(int numOne, int numTwo) {
        if(numTwo != 0){
            return numOne % numTwo;
    } else {
        return 0;
    }
    }
}