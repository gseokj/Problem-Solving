def dp_test(n,k):
    dp=[[0]*(n+1) for i in range(k+1)]
    for i in range(k+1):
        for j in range(n+1):
            if i == 1:
                dp[i][j] = 1
            else:
                dp[i][j] = dp[i][j-1] + dp[i-1][j]
    return dp[k][n]
n,k=map(int,input().split())
print(dp_test(n,k)%1000000000)