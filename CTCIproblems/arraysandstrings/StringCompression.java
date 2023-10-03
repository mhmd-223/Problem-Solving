package CTCIproblems.arraysandstrings;

/**
 * Problem Statement
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string 'aabcccccaaa' would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * <p>
 * Approach
 * We want a string that we can modify and append to dynamically, so a string builder is optimal here.
 */
public class StringCompression {

    public String compress(String s) {
        if (s == null || s.isEmpty()) return s;

        var sb = new StringBuilder();
        int length = s.length();

        for (int i = 0; i < length; ) {
            int count = 0;
            char c = s.charAt(i);
            int j;
            for (j = i; j < length && c == s.charAt(j); j++) count++;
            sb.append(c).append(count);
            i = j; // move to the next set of characters
        }

        return sb.length() < s.length() ? sb.toString() : s;
    }
}
