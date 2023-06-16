import sys
input = sys.stdin.readline
from math import factorial
n = int(input())
ans = factorial(n)
print(str(int(str(ans)[::-1]))[0])