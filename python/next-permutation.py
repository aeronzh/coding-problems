"""
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
"""
class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        print(nums, end='', flush=True)
        r = len(nums) - 1
        i = -1
        max_index = -1
        cursor_index = -1
        while True and r >= max_index:
            cursor = r
            i = cursor - 1
            while i >= 0 and nums[cursor] <= nums[i]:
                i -= 1

            if i >= 0:
                if i > max_index:
                    max_index = i
                    cursor_index = cursor
       

            r -= 1
             

        if cursor_index >= 0:
            tmp = nums[cursor_index]
            nums[cursor_index] = nums[max_index]
            nums[max_index] = tmp
            result = nums[:max_index+1] + sorted(nums[max_index+1:])

            for i in range(0, len(result)):
                nums[i] = result[i]
        else:
            nums.sort()   



def main():
    solution = Solution()
 
    solution.nextPermutation([1, 2, 3])
    solution.nextPermutation([1, 2, 0])
    solution.nextPermutation([2, 4, 1, 3, 2])
    solution.nextPermutation([1, 1, 5])
    solution.nextPermutation([1])
    solution.nextPermutation([])
    solution.nextPermutation([3, 2, 1])
    solution.nextPermutation([1, 3, 2])
    solution.nextPermutation([1,5,1])
    solution.nextPermutation([4,2,0,2,3,2,0])
    

if __name__ == "__main__": main()