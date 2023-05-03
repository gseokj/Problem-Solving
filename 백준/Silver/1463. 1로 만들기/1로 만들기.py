def dp_test(n):
    dp = [0]*(n+1)
    # dp[0] = 0
    # dp[1] = 0
    for i in range(2,n+1) :
        dp[i] = dp[i-1] + 1
        if i % 3 == 0 :
            dp[i] = min(dp[i], dp[i//3]+1)
        if i % 2 == 0 :
            dp[i] = min(dp[i], dp[i//2]+1)
    return dp[n]
target=int(input())
print(dp_test(target))
                