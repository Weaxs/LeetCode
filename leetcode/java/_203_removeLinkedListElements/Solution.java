package _203_removeLinkedListElements;

import basic.ListNode;

/**
 * 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode pre = start;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
                current.next = null;
                // current.next此时是null，且pre不用向前，只有current向前
                current = pre.next;
            } else {
                current = current.next;
                pre = pre.next;
            }
        }
        return start.next;
    }

    // 官方  官方的没有清楚删掉节点的next指针
    public ListNode removeElements2(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            }
            else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }


    public static void main(String[] args) {

    }

}
