"""
### Misère Nim
Two people are playing game of Misère Nim. The basic rules for this game are as follows:

- The game starts with $n$ piles of stones indexed from $0$ to $n-1$. Each pile $i$ (where $0 \le i \le n$) has $s_i$ stones.
- The players move in alternating turns. During each move, the current player must remove one or more stones from a single pile.
- The player who removes the last stone loses the game.

Given the value of  and the number of stones in each pile, determine whether the person who wins the game is the first or second person to move. 
If the first player to move wins, print `First` on a new line; otherwise, print `Second`. Assume both players move optimally.

**Input Format**

The first line contains an integer, $T$, denoting the number of test cases. 
Each of the $2T$ subsequent lines defines a test case. Each test case is described over the following two lines:

1. An integer, $n$, denoting the number of piles.
2. $n$ space-separated integers, $s_0,s_1,\dots, s_{n-1}$, where each $s_i$ describes the number of stones at pile $i$.

**Constraints**
- $1 \le T \le 100$
- $1 \le n \le 100$
- $1 \le s_i \le 10^9$

**Output Format**

For each test case, print the name of the winner on a new line (i.e., either `First` or `Second`).

**Sample Input**
```
2
2
1 1
3
2 1 3 
```

**Sample Output**
```
First
Second
```

http://mathoverflow.net/questions/71802/analysis-of-misere-nim

https://brilliant.org/wiki/nim/

"""
import sys
from collections import defaultdict

					
def main():
	f = open("in.txt")
	tests = int(f.readline())
	for t in range(0, tests):
		n = int(f.readline())
		piles = [int(i) for i in f.readline().split()]

		nimSum = 0
		outcome = 1
		for n in piles:
			if n > 1:
				outcome = 0
			nimSum ^= n
			
		if nimSum == outcome:
			print("Second")
		else:
			print("First")
		
				
main()	
				
				
				
