"""
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
"""
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums = sorted(nums)
        
        ans = []
        for i in range(0,len(nums)-1):
            if i==0 or (nums[i-1]!=nums[i]):
                l = i + 1
                r = len(nums) - 1
                while r > l:
                    s = nums[i] + nums[l] + nums[r]
                    if s == 0:
                        ans.append([nums[i], nums[l], nums[r]])
                        l += 1
                        r -= 1

                        # Skip duplicates
                        while l<r and nums[i]==nums[l]:
                            l += 1

                        while l<r and nums[r]==nums[r+1]:
                            r -= 1

                    elif s < 0:
                        # we have |nums[i] + nums[l]| > nums[r] --> we need to increase l (in order to decrease |nums[i] + nums[l]| 
                        # since nums[r] would only get smaller if we were to decrease r)
                        l += 1
                    else:
                        r -= 1
        return ans

def main():
    solution = Solution()
    print(solution.threeSum([-1,0,1,2,-1,-4]))
    print(solution.threeSum([0,0,0,0]))

if __name__ == "__main__": main()