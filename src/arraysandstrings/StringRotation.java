package arraysandstrings;

import java.util.Scanner;

/**
 * String Rotation: Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
 * call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 */
public class StringRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(checkRotation(s1, s2));
    }

    private static boolean checkRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            StringBuilder sbAppended = new StringBuilder();
            sbAppended.append(s2);
            sbAppended.append(s2);
            return isSubString(sbAppended.toString(), s1);
        }
        return false;
    }

    //Assume you have a method isSubstring which checks if one word is a substring of another.
    private static boolean isSubString(String original, String derived) {
        return original.contains(derived);
    }
}
