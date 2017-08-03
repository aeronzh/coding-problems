"""
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
"""
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        ans = 0

        # Move from left to right
        i = 0
        while i < len(height):
            cap = 0
            l = height[i]
            j = i + 1
            while j < len(height) and height[j] < l:
                cap += (l - height[j])
                j += 1
            
            if j < len(height) and height[j] >= l:
                ans += cap
            i = j
    

        # Move from right to left
        i = len(height) - 1
        while i >= 0:
            cap = 0
            r = height[i]
            j = i - 1
            while j >= 0 and height[j] <= r:
                cap += (r - height[j])
                j -= 1
            
            if j >= 0 and height[j] >= r:
                ans += cap
            i = j

   
        return ans

def main():
    solution = Solution()
    print(solution.trap([0,1,0,2,1,0,1,3,2,1,2,1])) # 6
    print(solution.trap([4,2,3])) # 1
    print(solution.trap([4,2,0,3,2,5])) # 9
    print(solution.trap([6,8,5,0,0,6,5])) # 13
    print(solution.trap([2,0,2])) # 2

if __name__ == "__main__": main()