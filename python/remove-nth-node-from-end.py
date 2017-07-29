"""
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.
"""
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None
    
    def __str__(self):
        head = self
        ans = ''
        while head != None:
            ans = ans + str(head.val)
            head = head.next
            if head != None:
                ans = ans + '->'

        return ans


class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        i = head
        j = head

        # Fast forward j n positions
        for count in range(0,n):
            j = j.next

        # Iterate over the list one by one until j hits the end
        while j != None and j.next != None:
            j = j.next
            i = i.next
            
        # print("i=%s  j=%s" %(i.val, j.val))

        # j reached the end. This means i points to the (n+1)th node from the end of list (since j was n nodes ahead)

        if j != None:
            i.next = i.next.next
        else:
            # Remove i itself
            head = head.next

        return head


def main():
    head = ListNode(1)
    node = head
    for x in range(2, 6):
        node.next = ListNode(x)
        node = node.next

    solution = Solution()
    print(solution.removeNthFromEnd(head, 2))

    head = ListNode(1)
    print(solution.removeNthFromEnd(head, 1))

    head = ListNode(1)
    head.next = ListNode(2)
    print(solution.removeNthFromEnd(head, 2))

if __name__ == "__main__": main()