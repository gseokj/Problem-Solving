import sys
x, y = map(str, sys.stdin.readline().split())
z = str(int(x[::-1]) + int(y[::-1]))
print(int(z[::-1]))