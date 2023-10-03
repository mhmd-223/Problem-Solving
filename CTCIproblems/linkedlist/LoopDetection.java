package CTCIproblems.linkedlist;

/**
 * Problem Statement
 * Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 * <p>
 * Approach
 * Using Fast/Slow runner technique, the two pointers will collide at some node due to the loop
 * but if we returned either one to the head of the list and start moving both at the same pace
 * they will collide again, but this time at the node at the beginning of the loop.
 */
public class LoopDetection {

    public Node getStartOfLoop(Node head) {
        if (head == null || head.next == null) return null; // no loop

        Node fast, slow;
        fast = slow = head;
        boolean isLoop = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // collision
            if (slow == fast) {
                isLoop = true;
                break;
            }
        }
        if (!isLoop) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // 1st node in the loop
    }
}
