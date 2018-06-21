package arraysandstrings;

import java.util.Scanner;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rea rrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat". "atco cta". etc.)
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isPalindromePerm(sc.nextLine().toLowerCase()));
    }

    private static boolean isPalindromePerm(String str) {
        int[] val = new int[128];
        for (char c : str.toCharArray()){
            if (c != ' '){
                if (val[c] == 0){
                    val[c]++;
                }
                else {
                    val[c]--;
                }
            }
        }
        int centerVal = 0;
        for (int i : val){
            if (i == 1){
                centerVal++;
                if (centerVal > 1)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
