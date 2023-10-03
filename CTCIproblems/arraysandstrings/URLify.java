package CTCIproblems.arraysandstrings;

/**
 * Problem Statement
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: if implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith     ", 13
 * Output: "Mr%20John%20Smith"

 * Approach
 * if we started from the string rightmost, moving characters to the right, we end up having
 * enough spaces for '%20' code to fill.

 * Illustration
 * - "Mr John Smith     "
 *               i^   j^
 * - "Mr John Smith    h"
 *               i^   j^
 * - "Mr John Smith   th"
 *              i^   j^
 *              .
 *              .
 *              .
 * - "Mr John Smit0Smith"
 *          i^   j^
 * - "Mr John Smi20Smith"
 *          i^  j^
 * - "Mr John Sm%20Smith"
 *          i^ j^
 *   and so on...
 */

public class URLify {

    /**
     * Encoding spaces within a string into "%20"
     *
     * @param s the string to replace its spaces with %20, assuming it has sufficient trailing spaces for conversion
     * @param trueLength the true length of the given s
     * @return the modified string
     */
    public String urlify(String s, int trueLength) {
        if (s == null || s.isEmpty()) return s;

        char[] str = s.toCharArray(); // to modify in place
        int i = trueLength - 1;
        int j = str.length - 1;
        char[] code = {'%', '2', '0'};

        while (i >= 0 && j > i) {
            // it is time to encode
            if (str[i] == ' ') {
                for (int k = code.length - 1; k >= 0; k--, j--)
                    str[j] = code[k];
            } else str[j--] = str[i]; // move to-last characters to end of the string
            i--;
        }
        return new String(str);
    }
}
