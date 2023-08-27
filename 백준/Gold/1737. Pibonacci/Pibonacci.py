import math

MOD = 10**18

dp = [[0] * 1001 for _ in range(1001)]

def solve(i, j, n):
    curr = n - 1 * i - math.pi * j
    if 0 <= curr <= math.pi:
        return 1
    elif curr < 0:
        return 0

    if dp[i][j]:
        return dp[i][j]

    dp[i][j] = (solve(i + 1, j, n) + solve(i, j + 1, n)) % MOD
    return dp[i][j]

n = float(input())
print(solve(0, 0, n))