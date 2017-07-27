"""
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
"""
class Solution(object):
    def generate(self, n, open_count, closed_count, s, result, visited):
        visited.add(s)

        if open_count == n and closed_count == n:
            result.append(s)
     
        for i in range(0, 2*n-len(s)):
            if open_count < n and not s+'(' in visited:
                self.generate(n,open_count+1, closed_count, s+'(', result, visited)
            if closed_count < open_count and not s+')' in visited:
                self.generate(n,open_count, closed_count+1, s+')', result, visited)
                
        
            
        
        
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []
        self.generate(n, 0, 0, '', ans, set())
        return ans

def main():
    solution = Solution()
    print(solution.generateParenthesis(10))

if __name__ == "__main__": main()