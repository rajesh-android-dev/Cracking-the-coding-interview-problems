package arraysandstrings;

import java.util.Scanner;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, pIe -> true
 * pales. pale -> true
 * pale. bale -> true
 * pale. bake -> false
 */
public class OneAway {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(findOnePossibleEdit(str1,str2));
    }

    private static boolean findOnePossibleEdit(String str1, String str2) {
       if (str1.length() == str2.length()){
          return oneEditReplace(str1,str2);
       }else if (str1.length()+1 == str2.length()){
           return oneEditInsert(str1,str2);
       }else if (str1.length() - 1 == str2.length()){
           return oneEditInsert(str2,str1);
       }
       return false;
    }

    private static boolean oneEditInsert(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < str2.length() && index1 < str1.length()){
            if (str1.charAt(index1) != str2.charAt(index2)){
                if (index1 != index2){
                    return false;
                }
                index2++;
            }else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private static boolean oneEditReplace(String str1, String str2) {
        boolean foundDifference = false;
        for (int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) != str2.charAt(i)){
                if (foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }
}
