class Solution(object):
    def generate(self, n):
        if n % 15 == 0:
            return 'fizz buzz'
        if n % 3 == 0:
            return 'fizz'
        if n % 5 == 0:
            return 'fuzz'

        return str(n)
        
    def fizzbuzz(self, n):
        for i in range(1, n):
            print('%s, ' % self.generate(i), end="")
        print('%s ' % self.generate(n), end="")
        
def main():
    solution = Solution()
    solution.fizzbuzz(36)

if __name__ == "__main__": main()