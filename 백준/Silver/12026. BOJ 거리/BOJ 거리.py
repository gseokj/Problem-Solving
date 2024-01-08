import sys
input = sys.stdin.readline

N = int(input())
av = input().rstrip()

dp = [float('inf')] * N
dp[0] = 0

for i in range(1, N):
    for j in range(i):
        conds = [(('B', 'O'), i), (('O', 'J'), i), (('J', 'B'), i)]
        for f, s in conds:
            if av[j] == f[0] and av[i] == f[1]:
                dp[i] = min(dp[i], dp[j] + pow(i - j, 2))

if dp[N - 1] != float('inf'):
    print(dp[N - 1])
else:
    print(-1)