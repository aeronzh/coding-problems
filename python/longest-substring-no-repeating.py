"""
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
"""
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        ans = ""
        i = 0
        j = 0
        hist = set()

        while j < len(s):
            if s[j] in hist:
                if j - i > len(ans):
                    ans = s[i:j]

                condition = True
                while condition:
                    if s[i] in hist:
                        hist.remove(s[i])
                    if s[i] == s[j]:
                        condition = False
                    i += 1

            else:
                hist.add(s[j])
                j += 1
        
        if j - i > len(ans):
            ans = s[i:j]

        return len(ans)


        
def main():
    solution = Solution()
    print(solution.lengthOfLongestSubstring("abcabcbb"))
    print(solution.lengthOfLongestSubstring("bbbbb"))
    print(solution.lengthOfLongestSubstring("pwwkew"))
    print(solution.lengthOfLongestSubstring("abcabcbb"))
    print(solution.lengthOfLongestSubstring("c"))

if __name__ == "__main__": main()