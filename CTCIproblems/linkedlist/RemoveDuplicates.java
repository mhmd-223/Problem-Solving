package CTCIproblems.linkedlist;

import java.util.HashSet;

/**
 * Problem statement
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * Approach
 * To track repetition of elements we need ,obviously, a hash table. Once encountering an already existing
 * element, we can delete this node. Thus, we need to keep a reference for the previous node.
 * For the follow-up, brute force solution may be used to solve in O(n^2)
 */
public class RemoveDuplicates {
    public Node removeDup(Node head) {
        if (head == null || head.next == null) return head;

        var seen = new HashSet<Integer>(); // stores the elements seen previously
        Node cur = head, prev = head;

        while (cur!=null) {
            if (!seen.add(cur.val)) // existing, delete this node
                prev.next = cur.next;
            prev = cur;
            cur = cur.next;
        }
        return head; // modified
    }

}
