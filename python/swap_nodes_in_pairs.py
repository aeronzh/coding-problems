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
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        start = head

        if head != None and head.next != None:
            start = head.next
        
        while head != None and head.next != None:
            tmp = head.next
            head.next = tmp.next
            if tmp.next != None and tmp.next.next != None:
                head.next = tmp.next.next
            new_head = tmp.next
            tmp.next = head
            head = new_head
        
        return start


def main():
    start = ListNode(1)
    tmp = start
    for x in range(2, 9):
        tmp.next = ListNode(x)
        tmp = tmp.next
    
    print(start)
    solution = Solution()
    print(solution.swapPairs(start))

if __name__ == "__main__": main()