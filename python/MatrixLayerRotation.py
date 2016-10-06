"""

4 4 2
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16

3 4  8  12
2 11 10 16
1 7  6  15
5 9  13 14

"""
import sys

def getLayer(matrix, rows, columns, l):
	layer = []
	# top
	for c in range(l, columns-l):
		layer.append(matrix[l][c])
		
	# right
	for r in range(l+1, rows-l):
		layer.append(matrix[r][columns-l-1])
		
	# bottom
	for c in range(columns-l-2, l-1, -1):
		layer.append(matrix[rows-l-1][c])
		
	#left
	for r in range(rows-l-2, l, -1):
		layer.append(matrix[r][l])

	return layer
	


def rotateLayer(layer, positions):	
	n = len(layer)
	rotations = positions%n

	for r in range(0, rotations):
		# Rotate one position counter clockwise
		first = layer[0]
		for i in range(1, n):
			layer[i-1] = layer[i]
		layer[n-1] = first
		
def addLayer(matrix, rows, columns, layer, l):
	i = 0
	# top
	for c in range(l, columns-l):
		matrix[l][c] = layer[i]
		i+=1
		
	# right
	for r in range(l+1, rows-l):
		matrix[r][columns-l-1]= layer[i]
		i+=1
		
	# bottom
	for c in range(columns-l-2, l-1, -1):
		matrix[rows-l-1][c]= layer[i]
		i+=1
		
	#left
	for r in range(rows-l-2, l, -1):
		matrix[r][l]= layer[i]
		i+=1		
		
		
f = open("/Users/lucas/in.txt")
					
rows, columns, rotations = (int(i) for i in f.readline().split()) # rows, columns, rotations = (int(i) for i in raw_input().split())


matrix=[]
for r in range(0, rows):
	row = map(int, f.readline().split(" ")) # 	row = map(int, raw_input().split())
	matrix.append(row)



newMatrix = []
layers = min(rows,columns)/2

for l in range(0,layers):
	layer = getLayer(matrix, rows, columns, l)
	rotateLayer(layer, rotations)
	addLayer(matrix, rows, columns, layer, l)


for r in range(0, rows):
	for c in range(0, columns):
		print matrix[r][c],
	print


