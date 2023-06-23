import sys

n = int(input())
h = list(map(int, input().split()))
g = [[0] * n for _ in range(n)]

for i in range(n):
    for j in range(n):
        if i == j:
            continue
        g[i][j] = (h[i] - h[j]) / (i - j)

m = [0] * n

for i in range(n):
    c = 0
    for l in range(i):
        p = True
        for k in range(l + 1, i):
            if g[k][i] <= g[l][i]:
                p = False
        if p:
            c += 1
    for r in range(i + 1, n):
        p = True
        for k in range(i + 1, r):
            if g[i][k] >= g[i][r]:
                p = False
        if p:
            c += 1
    m[i] = c

print(max(m))
