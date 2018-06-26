package arraysandstrings;

import java.util.Scanner;

/**
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(compressString(sc.next()));
    }

    private static String compressString(String val) {
        StringBuilder sbResult = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < val.length();i++){
            countConsecutive++;

            if (i+1>= val.length() || val.charAt(i) != val.charAt(i+1)){
                sbResult.append(val.charAt(i));
                sbResult.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return sbResult.length() < val.length() ? sbResult.toString() : val;
    }
}
