import math
n=int(input())
if n<4: print(0)
else: print(math.factorial(n)//((math.factorial(n-4))*math.factorial(4)))