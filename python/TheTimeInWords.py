import sys

def numberToText(x):
	number = ["", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
			"sixteen", "seventeen", "eighteen", "nineteen"]
	tens = [ "", "ten", "twenty", "thirty", "forty", "fifty"]
	if (x<=19):
		return number[x]
	else:
		mod = x%10
		d = x/10
		return "%s %s" % (tens[d],number[mod])

				
h = int(raw_input().strip())
m = int(raw_input().strip())

if (m==0):
	print "%s o' clock" % numberToText(h)
else:
	if (m==1):
		print "%s minute past %s" % (numberToText(m),numberToText(h))
	elif (m==15):
		print "quarter past %s" % numberToText(h)
	elif (m>1 and m<=29):
		print "%s minutes past %s" % (numberToText(m),numberToText(h))
	elif (m==30):
		print "half past %s" % numberToText(h)
	elif ((m>30 and m<=44) or (m>45 and m<=58)):
		print "%s minutes to %s" % (numberToText(60-m),numberToText(h+1))
	elif (m==59):
		print "1 minute to %s" % numberToText(h+1)
	elif (m==45):
		print "quarter to %s" % numberToText(h+1)
		
