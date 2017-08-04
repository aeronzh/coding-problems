"""
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
"""
class Solution(object):
    def search(self, nums, n, start, end, ans):
        if start > end:
            return
        mid = start + (end - start)//2

        if n == nums[mid]:
            ans[0] = min(ans[0], mid)
            ans[1] = max(ans[1], mid)
        self.search(nums, n, start, mid-1, ans)
        self.search(nums, n, mid+1, end, ans)
            

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        ans = [len(nums), -1]
        self.search(nums, target, 0, len(nums)-1, ans)

        if ans[0]==len(nums):
            return [-1,-1]
        return ans


def main():
    solution = Solution()
    print(solution.searchRange([5, 7, 7, 8, 8, 10], 8))

if __name__ == "__main__": main()