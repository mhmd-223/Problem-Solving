package CTCIproblems.linkedlist;

/**
 * Problem Statement
 * Given two (singly) linked lists, determine if the two lists intersect. Return the
 * intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
 * kth node of the first linked list is the exact same node (by reference) as the jth node of the second
 * linked list, then they are intersecting.
 * <p>
 * Approach
 * Two intersected lists must have the same ending. This is valuable if we want to check intersection.
 * The problem here is we want to return which node they intersected in. This could be achieved if we start
 * traversing two lists from the same starting point.
 */
public class Intersection {

    public Node getIntersectionNode(Node list1, Node list2) {
        if (list1 == null || list2 == null) return null;

        int len1 = getLength(list1);
        int len2 = getLength(list2);
        int diff = Math.abs(len2 - len1);
        Node longer, shorter;
        longer = len1 > len2 ? list1 : list2;
        shorter = len1 > len2 ? list2 : list1;

        while (longer != null && diff-- > 0) longer = longer.next;

        while (longer != null && shorter != null && longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer == shorter? longer : null; // both are equal, return anyone. otherwise, null
    }

    private int getLength(Node head) {
        int len = 0;
        for (Node cur = head; cur != null; cur = cur.next) len++;
        return len;
    }
}
