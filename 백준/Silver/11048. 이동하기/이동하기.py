import sys
input = sys.stdin.readline
N, M = map(int, input().split())
dp = [[0] * (M + 1)] * (N + 1)
dp_lis = []
for i in range(N):
    dp_lis.append(list(map(int, input().split())))
for i in range(1, N+1):
    for j in range(1, M+1):
        dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + dp_lis[i-1][j-1]
print(dp[N][M])