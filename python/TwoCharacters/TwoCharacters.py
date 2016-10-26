"""
### Two Characters
String $t$ always consists of two distinct alternating characters. For example, if string $t$'s two distinct characters are `x` and `y`, 
then $t$ could be `xyxyx` or `yxyxy` but not `xxyy` or `xyyx`.

You can convert some string $s$ to string $t$ by deleting characters from $s$. When you delete a character from $s$, you must delete _all_
occurrences of it in $s$. For example, if $s=$ `abaacdabd` and you delete the character `a`, then the string becomes `bcdbd`.

Given $s$, convert it to the longest possible string $t$. Then print the length of string $t$ on a new line; if no string $t$ can be formed from $s$, print $0$ instead.

**Input Format**

The first line contains a single integer denoting the length of $s$. 
The second line contains string $s$.

**Constraints**
- $1 \le |s| \le 1000$
- $s$ only contains lowercase English alphabetic letters (i.e., `a` to `z`).


**Output Format**

Print a single integer denoting the maximum length of $t$ for the given $s$; if it is not possible to form string $t$, print $0$ instead.

**Sample Input**
```
10
beabeefeab
```

**Sample Output**
```
5
```

**Explanation**

The characters present in $s$ are `a`, `b`, `e`, and `f`. This means that $t$ must consist of _two_ of those characters.

If we delete `e` and `f`, the resulting string is `babab`. This is a valid $t$ as there are only two distinct characters (`a` and `b`), 
and they are alternating within the string.

If we delete `a` and `f`, the resulting string is `bebeeeb`. This is not a valid string $t$ because there are _three_ consecutive `e`'s present.

If we delete only `e`, the resulting string is `babfab`. This is not a valid string $t$ because it contains _three_ distinct characters.

Thus, we print the length of `babab`, which is $5$, as our answer.
"""

import sys
from collections import defaultdict

def areAlternating(indicesX, indicesY):
	if abs(len(indicesX) - len(indicesY)) > 1:
		return False

	# 'a': [2, 8] and 'b': [0, 3, 9],
	i,j = 0, 0
	nextX = indicesX[i]
	nextY = indicesY[j]
	lastUsedX = -1
	lastUsedY = -1
	startingWithX = nextX < nextY
	while i < len(indicesX) and j < len(indicesY):
		nextX = indicesX[i]
		nextY = indicesY[j]
		if startingWithX and nextY < nextX:
			return False
		if not startingWithX and nextX < nextY:
			return False
		if lastUsedY > 0 and nextX < lastUsedY:
			return False
		if lastUsedX > 0 and nextY < lastUsedX:
			return False
			
		lastUsedX = nextX
		lastUsedY = nextY
		
		i += 1
		j += 1
		
	if j < len(indicesY):
		# We have one remaining y
		lastUsedY = nextY
		nextY = indicesY[-1] 
		if lastUsedY > nextX:
			return False
		
			
	if i < len(indicesX):
		# We have one remaining x
		lastUsedX = nextX
		nextX = indicesX[-1] 
		if lastUsedX > nextY:
			return False
			
	return True
					
def main():
	f = open("in.txt")
	n = int(f.readline())
	s = list(f.readline().strip())
	
	map = defaultdict(list)
	# Map character -> List containing indices where character appears.
	for index, char in enumerate(s):
		map[char].append(index)
	
	maximum = 0
	for x in map:
		for y in map:
			if x != y and areAlternating(map[x], map[y]):
				maximum = max(maximum, len(map[x]) + len(map[y]))
	
	print(maximum)


main()	
				
				
				
