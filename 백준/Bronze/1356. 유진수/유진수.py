from sys import stdin
input = stdin.readline

def is_ujin(a, b):
    x, y = 1, 1
    for i in a:
        x *= int(i)
    for j in b:
        y *= int(j)
    return x == y

n = input().rstrip()
flag = any(is_ujin(n[:i], n[i:]) for i in range(1, len(n)))

print("YES" if flag else "NO")
