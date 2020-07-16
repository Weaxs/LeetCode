
from python.basic import ListNode

# 合并两个有序链表
# 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
#
# 示例：
# 输入：1->2->4, 1->3->4
# 输出：1->1->2->3->4->4
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        elif not l2:
            return l1
        if l1.val <= l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l2.next, l1)
            return l2

    def mergeTwoLists2(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 and l2:
            if l1.val > l2.val:
                l1, l2 = l2, l1
            l1.next = self.mergeTwoLists2(l1.next, l2)
        return l1 or l2

    def mergeTwoLists3(self, l1: ListNode, l2: ListNode) -> ListNode:
        preHead = ListNode(1)
        prev = preHead
        while l1 and l2:
            if l1.val <= l2.val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2.next
            prev = prev.next
        # 将l1或者l2剩下的节点添加在后面
        prev.next = l1 if l1 is not None else l2
        return preHead.next

l13 = ListNode(4)
l12 = ListNode(2, l13)
l11 = ListNode(1, l12)
l23 = ListNode(4)
l22 = ListNode(3, l23)
l21 = ListNode(1, l22)

mergeList = Solution().mergeTwoLists3(l11, l21)
print()