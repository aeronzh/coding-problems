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
Input 'gigxx'. Convert 'gigxx' to 'abacc'

Algorithm:
Iterate over all characters of the input string:
	- If one character has not been changed before (and thus not contained in changedChars), change it to the next available char (a,b,c,d,..)
	- If we have changed the character before, reuse the replacement character.
	
Example:
Input 'gigxx'

First character is 'g'. Change 'g' -> 'a', since it is the first character we are changing, we start with 'a'. All follow up 'g' will be transformed to an 'a'
Next, is 'i'. Since we haven't changed an 'i' before, we change it to 'b'.
Next, is a 'g'. Since we already transformed a 'g' before, we change this one also to 'a'.
Next, is 'x'. Since we haven't changed an 'x' before, we change it to 'c'.
Next, is another 'x'. Since we already transformed an 'x' before, we change this one also to 'c'.

Result: 'abacc'
"""
def normalize(str):
	length = len(str)
	s = list(str)
	char = 'a'
	changedChars = {}
	changedChars[s[0]] = char
	s[0] = char
	
	for i in range(1,length):
		if (s[i] in changedChars):
			s[i] = changedChars[s[i]]
		else:
			char = chr(ord(char)+1)
			changedChars[s[i]] = char
			s[i] = char
		
	return "".join(s)
	
"""
Return true if the normalized version of str is the same as the normalized version of target. False otherwise.
"""	
def isSimilar(str, target):
	strNorm = normalize(str)
	targetNorm = normalize(target)
	return (strNorm == targetNorm)
	
def solve(l,r,s,subStrings):
    target = s[l-1:r]
    subStrCandidates =  subStrings[r-l+1]
    count = 0
    for str in subStrCandidates:
        if (isSimilar(str, target)):
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


		
signatures = {}
main()	
				
				
				
