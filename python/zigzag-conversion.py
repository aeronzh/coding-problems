"""
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
"""
class Solution(object):
    def convert(self, s, n):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if n==1:
            return s

        ans = ""
        for level in range(0, n):
            i = level
            go_down = True
            while i < len(s):
                ans = ans + s[i]
                if level == 0:
                    i += 2*(n - level - 1)
                elif level == n - 1:
                    i += 2*level
                elif go_down:
                    i += 2*(n - level - 1)
                    go_down = False
                else:
                    i += 2*level
                    go_down = True
                    
            
        return ans
                




def main():
    solution = Solution()
    print(solution.convert("PAYPALISHIRING", 2))

    

if __name__ == "__main__": main()