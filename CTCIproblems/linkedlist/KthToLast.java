package CTCIproblems.linkedlist;

/**
 * Problem statement
 * Implement an algorithm to find the kth to last element of a singly linked list
 * <p>
 * Approach
 * If the length of the list is known, it is trivial, return n - k element, this is not the case here
 * What if we start counting backwards ? For instance, if we somehow asked each node about
 * its position starting from the last node, we can find the kth-to-last node fairly easily.
 * To make the node know its position, it may ask the previous node and add one to its position.
 * This can be achieved recursively, but we need to return both position and the node.
 * We can use a field variable to be accessible for all recursive calls to store the result node.
 */
public class KthToLast {
    private Node resultNode;


    /**
     * Returns the kth-to-last node in a linked list
     *
     * @param head the head of the linked list to be searched
     * @param k    the to-last node to be returned, k = 1, 2, ...
     * @return kth-to-last node, null if k is invalid or larger than the list length.
     */
    public Node findKthToLastNode(Node head, int k) {
        if (head == null) return null;
        findKthToLastNodeRec(head, k);
        return resultNode;
    }

    private int findKthToLastNodeRec(Node head, int k) {
        if (head == null) return 0;

        int prevPos = findKthToLastNodeRec(head.next, k); // count backwards

        prevPos++; // add to calculate your position
        if (prevPos == k)
            resultNode = head;

        return prevPos;
    }
}
