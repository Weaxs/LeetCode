package _206_reverse_linked_list;

import basic.ListNode;

public class Solution {

    /**
     * 迭代
     */
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = previous;
            previous = current;
            current = nextTemp;
        }
        return previous;
    }

    public static void main(String[] args) {

    }

}
