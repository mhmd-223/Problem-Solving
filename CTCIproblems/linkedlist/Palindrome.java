package CTCIproblems.linkedlist;

import java.util.Stack;

/**
 * Problem Statement
 * Implement a function to check if a linked list is a palindrome.
 *
 * Approach
 * Consider: 1->2->3->2->1, it is observed that after the middle node, the right sublist is the reverse
 * of the left sublist. We can use a stack to store the right sublist and get it back reversed.
 */
public class Palindrome {
    public boolean isPalindrome(Node list) {
        var stack = new Stack<Integer>();
        Node fast, slow;
        fast = slow = list;
        /* Get the middle node */
        while (fast != null && fast.next != null) {
            stack.push(slow.val); // store the left sublist
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) // odd number of nodes
            slow = slow.next;

        /* Slow now points to the start of right sublist */
        while (!stack.isEmpty()) {
            if (slow.val != stack.pop())
                return false;
            slow = slow.next;
        }
        return true;
    }
}
