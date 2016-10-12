import sys
from collections import defaultdict

"""
Create a dictionary of lists. map[i] holds a list with all the substrings of str that have
length i.
"""
def getAllSubstrings(str):
	map = defaultdict(list)
	length = len(str)
	for i in range(length):
		for j in range(i,length):
			subStringLen = j - i + 1
			map[subStringLen].append(str[i:j+1])
	return map

"""
For example "ggi":
    1st 2nd 3rd
1st      ==  !=
2nd          !=
3rd
"""
def signature(str):
	length = len(str)
	sig = [[False]*(length) for i in range(length)]
	for i in range(0, length):
		sig[i][i] = True
		
	for i in range(0, length):
		for j in range(i+1, length):
			sig[i][j] = (str[i] == str[j])
			sig[j][i] = sig[i][j]
			
	return sig

"""
Return true if str has the same signature as targetSig. Returns False otherwise
"""	
def isSimilar(str, targetSig):
	length = len(str)
	strSig = signature(str)
	for i in range(0, length):
		for j in range(i+1, length):
			if (strSig[i][j] != targetSig[i][j]):
				return False
	return True
	
	
def solve(l,r,s,subStrings):
    target = s[l-1:r]
    targetSig = signature(target)
    targetLength = len(target)
    subStrCandidates =  subStrings[targetLength]
    count = 0
    for str in subStrCandidates:
        if (isSimilar(str, targetSig)):
            count += 1
	
    return count
	
    
def main():
	f = open("in.txt")
	n, queries = (int(i) for i in f.readline().split())
	s = f.readline().rstrip()
	subStrings = getAllSubstrings(s)
	for q in range(0, queries):
		l, r = (int(i) for i in f.readline().split())        
		print(solve(l,r,s,subStrings))


main()	
				
				
				
