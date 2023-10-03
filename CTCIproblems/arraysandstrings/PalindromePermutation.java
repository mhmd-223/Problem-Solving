package CTCIproblems.arraysandstrings;

/**
 * Problem Statement
 * Given a string, write a function to check if it is a permutation of
 * a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome does not need to be limited to just
 * dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: 'taco cat', "atco eta", etc.)
 *
 * Approach
 * In a palindrome string, each character must have an even count of repetition
 * except for one and only one character, it can be repeated some odd count.
 * In fact, we do not bother to know the exact count, we just want to know if it's even or odd.
 * To achieve such a task, we can consider a bit vector, keeping switching its bits. Starting from 0
 * we must go back to 0 again after some even count of switches, otherwise it is odd.
 * But, how can we ensure that only one bit is set ?
 * consider: 001000, if we subtracted 1 we get "000111", bitwise and both we get zero. It is power of 2.
 * we can also check if it is power of 2 by repetitive division by two, although it takes O(log n), n is the number
 */
public class PalindromePermutation {
    public boolean isPalindromePermutation(String s) {
        if (s == null) return false;
        if (s.isEmpty()) return true;

        s = s.toLowerCase(); // case insensitive
        int checker = 0; // acts as bit vector, checker = 0b000....0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue; // skip spaces
            int pos = c - 'a'; // position in bit array
            checker ^= (1 << pos); // toggle this bit
        }

        return (checker & (checker - 1)) == 0; // ensure that at least one bit is set
    }
}
