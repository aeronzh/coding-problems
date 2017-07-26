class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        power_set = []
        power_set.append([])
        for n in nums:
            new_power_set = []
            for subset in power_set:
                new_power_set.append(subset)
                new_subset = subset[:]
                new_subset.append(n)
                new_power_set.append(new_subset)
            power_set = new_power_set
            
        return power_set


def main():
    solution = Solution()
    print(solution.subsets([1,2,3]))

if __name__ == "__main__": main()