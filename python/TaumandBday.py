"""
 Taum is planning to celebrate the birthday of his friend, Diksha. 
 There are two types of gifts that Diksha wants from Taum: one is black and the other is white.
 To make her happy, Taum has to buy  number of black gifts and number of white gifts.

 The cost of each black gift is x units.
 The cost of every white gift is y units.
 The cost of converting each black gift into white gift or vice versa is z units.
 
 Help Taum by deducing the minimum amount he needs to spend on Diksha's gifts.
 
 Input Format
 The first line will contain an integer T which will be the number of test cases.
 There will be T pairs of lines. The first line of each test case will contain the 
 values of integers B and W. Another line of each test case will contain the values of integers X, Y, and Z.

"""

import sys

tests = int(raw_input().strip())
for t in xrange(tests):
	b,w = raw_input().strip().split(' ')
	b,w = [long(b),long(w)]
	x,y,z = raw_input().strip().split(' ')
	x,y,z = [long(x),long(y),long(z)]
	
	if (x>y+z):
		blackPrice = y+z
	else:
		blackPrice = x
		
	if (y>x+z):
		whitePrice = x+z
	else:
		whitePrice = y
		
	total = b*blackPrice + w*whitePrice
	
	print total
