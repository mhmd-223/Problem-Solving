package CTCIproblems.arraysandstrings;

/**
 * Problem Statement
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 * <p>
 * Approach
 * For s2 to be a rotation of s1, s2 must be a substring of s1 + s1. For instance,
 * if s1 = cdab, s2 = abcd, then s1+s1 = cd'abcd'ab, it contains s2
 */
public class StringRotation {
    public boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.isEmpty() || s2.isEmpty()) return false;
        if (s1.length() != s2.length()) return false; // to be a rotation, it must have the same length

        String s = s1 + s1;
        return isSubstring(s, s2);
    }

    private boolean isSubstring(String s, String t) {
        if (s.length() > t.length())
            return s.contains(t);
        return t.contains(s);
    }
}
