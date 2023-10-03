package CTCIproblems.linkedlist;

/**
 * Problem Statement
 * Implement an algorithm to delete a node in the middle (i.e., any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a ->b->d->e->f
 * <p>
 * Approach
 * Given only the middle node, we can overwrite on it, i.e. clone the next node to the middle node.
 * ex: a->b->c->d->e->f ===> a->b->d->e->f
 */
public class DeleteMiddleNode {
    public boolean deleteMiddle(Node middle) {
        if (middle == null || middle.next == null) return false;

        /* Copy next node to the middle */
        middle.next = middle.next.next;
        middle.val = middle.next.val;

        return true;
    }
}
