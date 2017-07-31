"""
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
"""
class Solution(object):
    def binarySearch(self, nums, n, start, end):
        if start <= end:
            mid = start + (end - start) // 2

            if n == nums[mid]:
                return mid
            elif n < nums[mid] and n < nums[start]:
                if nums[start] > nums[mid]:
                    # left
                    return self.binarySearch(nums, n, start, mid-1)
                else:
                    # right
                    return self.binarySearch(nums, n, mid+1, end)
            elif n < nums[mid]:
                # left
                return self.binarySearch(nums, n, start, mid-1)
            elif n > nums[mid] and n > nums[end]:
                if nums[start] < nums[mid]:
                    # right
                    return self.binarySearch(nums, n, mid+1, end)
                else:
                    # left
                    return self.binarySearch(nums, n, start, mid-1)
            elif n > nums[mid]:
                # right
                return self.binarySearch(nums, n, mid+1, end)


        else:
            return -1
        

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        return self.binarySearch(nums, target, 0, len(nums)-1)

def main():
    solution = Solution()
    print(solution.search([4, 5, 6, 7, 0, 1, 2], 0)) # 4
    print(solution.search([4, 5, 6, 7, 0, 1, 2], 1)) # 5
    print(solution.search([4, 5, 6, 7, 0, 1, 2], 2)) # 6
    print(solution.search([4, 5, 6, 7, 0, 1, 2], 4)) # 0
    print(solution.search([4, 5, 6, 7, 0, 1, 2], 5)) # 1
    print(solution.search([4, 5, 6, 7, 0, 1, 2], 6)) # 2
    print(solution.search([4, 5, 6, 7, 0, 1, 2], 7)) # 3

    print(solution.search([4, 5, 6, 7, 8, 1, 2, 3], 8)) # 4
    print(solution.search([5, 1, 2, 3, 4], 1)) # 1

if __name__ == "__main__": main()

