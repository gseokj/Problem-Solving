import sys

N, L, W, H = map(int, sys.stdin.readline().split())
S, E = 0, max(L, W, H)

for _ in range(10000):
    M = (S + E) / 2
    count = (L // M) * (W // M) * (H // M)
    if count >= N:
        S = M
    else:
        E = M

print("%.10f" %(E))