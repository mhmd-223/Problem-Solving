package CTCIproblems.arraysandstrings;

/**
 * Problem statement
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * Approach
 * we can use a hashtable to store characters we have seen before.
 *
 * If we cannot use additional data structures, we can sort the string
 * in O(n log n) time and check adjacent characters, or we can use the brute force
 * solution and compare each character with the other n - 1 characters, this takes O(n^2)
 *
 */

public class IsUnique {

    /**
     * Determine whether a given string contains unique characters or not.
     *
     * @param s a string to check uniqueness of its characters, assuming it contains only 7-bit ASCII characters
     * @return true if s does not have repeated characters, false otherwise.
     */
    public boolean isUnique(String s) {
        if (s == null)
            return false; // cannot work with null reference
        if (s.isEmpty())
            return true; // empty string considered unique

        boolean[] isSeenBefore = new boolean[128]; // ASCII character set

        for (int i = 0; i < s.length(); i++) {
            int asciiCode = s.charAt(i); // implicit casting to int returns the ascii code
            if (isSeenBefore[asciiCode])
                return false; // not unique
            isSeenBefore[asciiCode] = true; // mark this character as seen
        }
        return true; // unique character
    }
}