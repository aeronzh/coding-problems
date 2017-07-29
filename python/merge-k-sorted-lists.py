"""
Merge k sorted linked lists and return it as one sorted list.
"""
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
    def merge(self, lst1, lst2):
        if lst1 == None:
            return lst2
        if lst2 == None:
            return lst1
        if lst1.val < lst2.val:
            lst1.next = self.merge(lst1.next, lst2)
            return lst1
        else:
            lst2.next = self.merge(lst1, lst2.next)
            return lst2


    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if len(lists) == 0:
            return None

        for i in range(0, len(lists) - 1):
            lists[i+1] = self.merge(lists[i], lists[i+1])

        return lists[-1]


def main():
    head1 = ListNode(1)
    head1.next =  ListNode(5)
    head1.next.next =  ListNode(15)

    head2 = ListNode(-1)
    head2.next =  ListNode(17)
    head2.next.next =  ListNode(19)

    head3 = ListNode(1)
    head3.next =  ListNode(18)
    head3.next.next =  ListNode(100)
    head3.next.next.next =  ListNode(200)

    solution = Solution()
    print(solution.mergeKLists([head1, head2, head3]))
    print(solution.mergeKLists([None]))
    print(solution.mergeKLists([None, ListNode(1)]))
    print(solution.mergeKLists([]))
    print(solution.mergeKLists([ListNode(1)]))

if __name__ == "__main__": main()