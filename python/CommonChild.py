"""
Given two strings a and b of equal length, what's the longest string (S) that can be constructed 
such that it is a child of both? 

A string x is said to be a child of a string y if x can be formed by deleting 0 or more characters 
from y. 

For example, ABCD and ABDC has two children with maximum length 3, ABC and ABD. Note that we will 
not consider ABCD as a common child because C doesn't occur before D in the second string.


Input format

Two strings, a and b, with a newline separating them.


Constraints

All characters are upper cased and lie between ASCII values 65-90. The maximum length of the strings 
is 5000.


Output format
Length of string S.

------------------------------------------
Sample Input #0
HARRY
SALLY

Sample Output #0
2

The longest possible subset of characters that is possible by deleting zero or more characters from HARRY 
and SALLY is AY, whose length is 2.

------------------------------------------
Sample Input #2
SHINCHAN
NOHARAAA

Sample Output #2
3

The largest set of characters, in order, between SHINCHAN and NOHARAAA is NHA.
------------------------------------------

"""
import sys

a, b = raw_input(), raw_input()

# This is a Longest Common Subsequence problem

n = len(a)+1

lcs = [[""]*(n) for i in xrange(n)] # lcs[i][j] holds the LCS of a[:i] and b[:j] 

for i in xrange(1, n):
	for j in xrange(1, n):
		if (a[i-1] == b[j-1]):
			lcs[i][j] = lcs[i-1][j-1] + a[i-1]
		else:
			if (len(lcs[i][j-1]) > len(lcs[i-1][j])):
				lcs[i][j] = lcs[i][j-1]
			else:
				lcs[i][j] = lcs[i-1][j]


				
print len(lcs[n-1][n-1])				
				
				
				
