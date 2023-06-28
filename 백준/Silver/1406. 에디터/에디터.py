import sys

I = sys.stdin.readline

s = list(I().strip())
t = []
n = int(I())

for _ in range(n):
    c, *a = I().split()
    if c == 'L' and s:
        t.append(s.pop())
    elif c == 'D' and t:
        s.append(t.pop())
    elif c == 'B' and s:
        s.pop()
    elif c == 'P':
        s.append(a[0])

print(''.join(s + t[::-1]))
