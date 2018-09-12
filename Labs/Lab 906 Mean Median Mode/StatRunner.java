/**
 * Lab 906:: Find Mean Median and Mode
 * 
 * @author (Emma Chiu) 
 * @version (906)
 */

public class StatRunner{
    
    public static void main(){
        StatTester st = new StatTester();
        st.loadArray();
        System.out.println("\n\n" + "Your array is: ");
        st.printArray();
        System.out.println("\n\n" + "Your sorted array is: ");
        st.sortArray();
        System.out.println("\n\n" + "Your sum is: " + st.getSum());
        System.out.println("Your mean is: " + st.getMean());
        System.out.println("Your median is: " + st.getMedian());
        System.out.print("Your mode(s) is (are): ");
        st.getMode();
    }
}
