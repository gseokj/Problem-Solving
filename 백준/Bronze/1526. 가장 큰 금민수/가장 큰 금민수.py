import sys
n = int(input())
c = False
if '4' in str(n) or '7' in str(n):
    c = all(d == '4' or d == '7' for d in str(n))
if c:
    print(n)
else:
    r = 0
    for i in range(4, n + 1):
        if '4' in str(i) or '7' in str(i):
            if all(d == '4' or d == '7' for d in str(i)):
                r = i
    print(r)