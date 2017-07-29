"""
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
"""
class Solution(object):
    def solve(self, candidates, target, s, combination, result, visited, start):
        if s == target:
            key = '-'.join([str(x) for x in sorted(combination)])
            if not key in visited:
                result.append(combination)
                visited.add(key)
                return
        
        if s < target:
            for i in range(start, len(candidates)):
                self.solve(candidates, target, s + candidates[i], list(combination) + candidates[i:i+1], result, visited, i)

    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        ans = []
        self.solve(candidates, target, 0,[],ans,set(), 0)
        return ans




def main():
    solution = Solution()
    print(solution.combinationSum([2, 3, 6, 7], 7))
    print(solution.combinationSum([37,31,46,35,47,21,22,42,33,23,26,41,36,39,48,43,34,24,45,25,29,32,38,44,49], 74))

if __name__ == "__main__": main()