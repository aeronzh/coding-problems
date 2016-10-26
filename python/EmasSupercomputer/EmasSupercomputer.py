import sys

"""
### Ema's Supercomputer

Ema built a quantum computer! Help her test its capabilities by solving the problem below.

Given a grid of size $N \times M$, each cell in the grid is either $good$ or $bad$.

A _valid_ plus is defined here as the crossing of two segments (horizontal and vertical) of equal lengths. These lengths must be odd, and the middle cell of its horizontal segment must cross the middle cell of its vertical segment.

In the diagram below, the blue pluses are _valid_ and the orange ones are _not valid_. 

<img src="image1.png">

Find the $2$ valid pluses that can be drawn on $good$ cells in the grid, and print maximum the product of their areas.

**Note:** The two pluses _cannot_ overlap, and the product of their areas should be maximum.

**Input Format**

The first line contains two space-separated integers, $N$ and $M$.
The $N$ subsequent lines contains $M$ characters, where each character is either **G** ($good$) or **B** ($bad$). 
If the $y^{th}$ character in the $x^{th}$ line is **G**, then $(x,y)$ is a $good$ cell (otherwise it's a $bad$ cell).

**Constraints**
- $2 \le N \le 15$
- $2 \le M \le 15$


**Output Format**

Find $2$ pluses that can be drawn on $good$ cells of the grid, and print maximum the product of their areas as an integer.

**Sample Input 0**
```
5 6
GGGGGG
GBBBGB
GGGGGG
GGBBGB
GGGGGG
```


**Sample Output 0**
```
5
```


**Sample Input 1**
```
6 6
BGBBGB
GGGGGG
BGBBGB
GGGGGG
BGBBGB
BGBBGB
```


**Sample Output 1**
```
25
```

**Explanation**

Here are two _possible solutions_ for **Sample 1** (left) and **Sample 2** (right): 

<img src="image2.png">

_Explanation Key:_

- _Green_: $good$ cell
- _Red_: $bad$ cell
- _Blue_: possible $pluses$.

For the explanation below, we will refer to a plus of length $i$ as $P_i$.

**Sample 0**
 
There is enough good space to color one $P_3$ plus and one $P_1$ plus. $Area(P_3) = 5\ units$, and $Area(P_1) = 1\ unit1$. 
The product of their areas is $5 \times 1 = 5$, so we print $5$.

**Sample 1**
 
There is enough good space to color two $P_3$ pluses. $Area(P_3) = 5\ units$. The product of the areas of our two $P_3$ pluses is $5 \times 5 = 25$, so we print $25$.
"""

def removePlus(grid, r, c, h, v):
	l = len(h)
	
	# Restore Horizontal
	index = 0
	for i in range(c-l//2, c+l//2+1):
		grid[r][i] = h[index]
		index += 1
	
	# Restore Vertical
	index = 0
	for i in range(r-l//2, r+l//2+1):
		grid[i][c] = v[index]
		index += 1

def addPlus(grid, r, c, l):
	# Horizontal
	h = []
	for i in range(c-l//2, c+l//2+1):
		h.append(grid[r][i])
		grid[r][i] = 'X'
	
	# Vertical
	v = []
	for i in range(r-l//2, r+l//2+1):
		if i != r:
			v.append(grid[i][c])
		else:
			v.append(h[l//2])
			
		grid[i][c] = 'X'
		
	return (h,v)

def isValidLocation(grid, r, c, l, n, m):
	if l%2 == 0:
		return False
	if c-l//2 < 0:
		return False
	if c+l//2 >= m:
		return False
	if r-l//2 < 0:
		return False
	if r+l//2 >= n:
		return False
		
	# Check Horizontal
	for i in range(c-l//2, c+l//2+1):
		if grid[r][i] == 'X' or grid[r][i] == 'B':
			return False
	
	# Check Vertical
	for i in range(r-l//2, r+l//2+1):
		if grid[i][c] == 'X' or grid[i][c] == 'B':
			return False
	
	return True

def solve(grid, n, m, count, area1, area2):
	global maximum
	if count == 2:
		maximum = max(maximum,area1*area2)
	else:
		for r in range(0, n):
			for c in range(0,m):
				for l in range(1, min(n,m)+1):
					if isValidLocation(grid, r, c, l, n, m):
						# Add one at r,c
						h,v = addPlus(grid,r,c,l)
						if count == 0:
							area1 = (2*l-1)
						else:
							area2 = (2*l-1)
						solve(grid, n, m, count+1, area1, area2)
						removePlus(grid, r, c, h, v)
						
def main():
	f = open("in.txt")
	n, m = (int(i) for i in f.readline().split())
	grid = []
	for r in range(0, n):
		grid.append(list(f.readline().strip()))
	
	solve(grid,n,m, 0, 0, 0)
	print(maximum)



maximum = 0	
main()
