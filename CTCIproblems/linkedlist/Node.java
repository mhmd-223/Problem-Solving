package CTCIproblems.linkedlist;

/**
 * A simple implementation of a singly linked list node.
 * For simplicity, the node will contain integers only.
 */
public class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

    /**
     * Appends a new node to the end of list
     * @param val the node's value to be appended.
     */
    void append(int val) {
        Node tail = new Node(val);
        Node head = this;
        while (head.next != null)
            head = head.next;
        head.next = tail;
    }

}
