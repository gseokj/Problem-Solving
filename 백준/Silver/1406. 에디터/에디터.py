import sys

input = sys.stdin.readline

s = list(input().strip())
t = []
n = int(input())

for _ in range(n):
    c, *a = input().split()
    if c == 'L' and s:
        t.append(s.pop())
    elif c == 'D' and t:
        s.append(t.pop())
    elif c == 'B' and s:
        s.pop()
    elif c == 'P':
        s.append(a[0])

print(''.join(s + t[::-1]))
