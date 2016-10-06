"""
A modified Kaprekar number is a positive whole number n with d digits, such that when we split its square into two pieces - 
a right hand piece r with d digits and a left hand piece l that contains the remaining d or d-1 digits, the sum of the 
pieces is equal to the original number (i.e.  l + r  = n).

Note: r may have leading zeros.
"""
import sys
						
p = int(raw_input().strip())
q = int(raw_input().strip())

count = 0
for x in range(p, q+1):
	d = len(str(abs(x)))
	s = str(x*x)
	sLen = len(s)
	if (sLen%2==0):
		r = s[-1*d:]
		l = s[:d]
	else:
		r = s[-1*d:]
		l = s[:d-1]
	
	if (not r):
		r = "0"
	if (not l):
		l= "0"
		
	if (int(l)+int(r) == x):
		count += 1
		print x,

if (count==0):
	print "INVALID RANGE"
