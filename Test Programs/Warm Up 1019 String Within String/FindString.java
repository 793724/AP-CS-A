/**
 * Warm Up 1019 String Within String
 *
 * @ Emma Chiu
 * @ 1019
 */

public class FindString {
    public static void main() {
        String s1 = "e";
        String s2 = "This week is homecoming wEEk.";
        System.out.println(strOcurs(s1, s2));
    }

    public static int strOcurs(String s1, String s2) {
        String s3 = s2.toLowerCase();
        int count = 0;
        for(int i = 0; i < s3.length() - s1.length(); i++) {
            if(s3.substring(i, i + s1.length()).equals(s1)) {
                count++;
            }
        }
        if(s3.substring(s3.length() - s1.length()).equals(s1)) {
            count++;
        }
        return count;
    }
}