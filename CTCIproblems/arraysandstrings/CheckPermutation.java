package CTCIproblems.arraysandstrings;

/**
 * Problem Statement
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 * <p>
 * Approach
 * Two permutations must have the same count of characters, so we can keep track
 * of each string's characters count and see if they match.
 */

public class CheckPermutation {
    /**
     * Determines if one of two strings is a permutation of the other.
     *
     * @param s the first string
     * @param t the second string
     * @return true if s is a permutation of t or vice versa, otherwise false.
     */

    public boolean isPermutation(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        int[] freq = new int[128]; // 7-bit ASCII character set
        int length = s.length(); // same for both
        for (int i = 0; i < length; i++) {
            freq[s.charAt(i)]++;
            freq[t.charAt(i)]--;
        }
        /* each element in frequency array must be zero */
        for (int i : freq) {
            if (i != 0) return false;
        }

        return true; // two are permutations
    }
}
