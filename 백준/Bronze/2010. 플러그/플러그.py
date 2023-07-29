import sys
n = int(sys.stdin.readline())
sum = 1
for i in range(n):
    t = int(sys.stdin.readline())
    sum+=t
print(sum-n)