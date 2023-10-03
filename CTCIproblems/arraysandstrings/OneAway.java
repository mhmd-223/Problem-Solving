package CTCIproblems.arraysandstrings;

/**
 * Problem Statement
 * There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 *
 * Approach
 * We start traversing both from the very beginning, each time we encounter a difference we track it.
 * the total differences count must be 0 or 1
 */
public class OneAway {
    public boolean isOneAway(String s, String t) {
        if (s == null || t == null) return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;

        int diffCount = 0; // count of differences
        int longerIndex = 0, shorterIndex = 0;
        String longer, shorter;
        longer = s.length() > t.length() ? s : t;
        shorter = t.length() > s.length() ? s : t;

        while (shorterIndex < shorter.length() && longerIndex < longer.length()) {
            char c1 = longer.charAt(longerIndex);
            char c2 = shorter.charAt(shorterIndex);
            if (c1 != c2) {
                diffCount++;
                if (longer.length() == shorter.length()) shorterIndex++; // replacement
            } else shorterIndex++; // insertion or removal
            longerIndex++;
        }

        return diffCount <= 1;
    }

}
