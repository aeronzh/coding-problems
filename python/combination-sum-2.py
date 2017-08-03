"""
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
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
                self.solve(candidates, target, s + candidates[i], list(combination) + candidates[i:i+1], result, visited, i+1)

    def combinationSum2(self, candidates, target):
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
    print(solution.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))

if __name__ == "__main__": main()