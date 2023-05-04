def dp_test(n):
    dp = [0,1,2,4] * n
    if n>3:
        for i in range(4,n+1):
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
    return dp[n]
for _ in range(int(input())):
    n = int(input())
    print(dp_test(n))