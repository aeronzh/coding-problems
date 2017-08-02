"""
Given a digit string, return all possible letter combinations that the number could represent.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
"""
class Solution(object):
    def solve(self, digits, i, current, ans):
        """
        :type digits: str
        :rtype: List[str]
        """
        if len(digits) == 0:
            if len(current) > 0:
                ans.append(current)
            return

        mapping = {2:['a','b','c'],
        3:['d','e','f'],
        4:['g','h','i'],
        5:['j','k','l'],
        6:['m','n','o'],
        7:['p','q','r', 's'],
        8:['t','u','v'],
        9:['w','x','y', 'z']}

        d = ord(digits[i]) - 48
        chars = mapping[d]
        for c in chars:
            self.solve(digits[i+1:], i, current + c, ans)

  

    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        ans = []
        self.solve(digits, 0, '', ans)
        return ans

            
def main():
    solution = Solution()
    print(solution.letterCombinations("23"))
    print(solution.letterCombinations(""))

if __name__ == "__main__": main()