package CTCIproblems.linkedlist;

import java.sql.Wrapper;

/**
 * Problem Statement
 * You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 *
 * Approach
 * Since two lists given in reverse order, i.e. 1st node is the rightmost digit, etc. We can
 * start summing from the beginning of the two lists. We hence need to store the carry of summation,
 * and we should consider the lists of different lengths.
 * This could be achieved recursively.
 * Ex: (7->1->6, 5->9->2, 0) => 5+7+0 => 2->1->9
 *        (1->6, 9->2, 1) => 1 + 9 + 1 => 1->9
 *          (6, 2, 1) => 2 + 6 + 1 => 9
 *              (null, null, 0) => null
 */
public class SumLists {

    public Node sumLists(Node a, Node b) {
        return sumLists(a, b, 0);
    }

    private Node sumLists(Node a, Node b, int carry) {
        if (a == null && b == null)
            return carry == 0 ? null : new Node(carry);

        int d1 = a == null ? 0 : a.val;
        int d2 = b == null ? 0 : b.val;
        /* Rest of digits */
        Node subA = a == null ? null : a.next;
        Node subB = b == null ? null : b.next;

        int sum = d1 + d2 + carry;
        Node res = new Node(sum % 10); // first digit of sum, a node contains a digit
        res.next = sumLists(subA, subB, sum > 9 ? 1 : 0);

        return res;
    }

    /**
     * Follow-up Approach
     * If they are in forward order, we need to start summing from the last node.
     * To do this, we need to return the carry back to the caller node, as well as the
     * result node. One solution may be to create a wrapper class.
     */
    public Node sumListsForwardOrder(Node a, Node b) {
        Wrapper wrapper = sumForward(a, b);
        if (wrapper.carry == 0)
            return wrapper.res;
        Node res = new Node(wrapper.carry);
        res.next = wrapper.res;
        return res;
    }
    private Wrapper sumForward(Node a, Node b) {
        if (a == null && b == null)
            return new Wrapper(); // empty wrapper

        int d1 = a == null ? 0 : a.val;
        int d2 = b == null ? 0 : b.val;
        /* Rest of digits */
        Node subA = a == null ? null : a.next;
        Node subB = b == null ? null : b.next;
        /* Current node must wait for the other nodes */
        Wrapper resWrapper = sumForward(subA, subB);
        int sum = d1 + d2 + resWrapper.carry;
        Node res = new Node(sum % 10);
        res.next = resWrapper.res;

        return new Wrapper(sum > 9 ? 1 : 0, res);
    }
    private static class Wrapper {
        int carry;
        Node res;

        public Wrapper(int carry, Node res) {
            this.carry = carry;
            this.res = res;
        }

        public Wrapper() {
        }
    }

}
