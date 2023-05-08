def dp_test(n):
    dp = [0] * (n + 1)
    dp[1] = 1
    dp[1] = 1

    for i in range(2, n + 1):
        dp[i] = dp[i - 1] + dp[i - 3]
    return dp[n]


n = int(input())
print(dp_test(n))

