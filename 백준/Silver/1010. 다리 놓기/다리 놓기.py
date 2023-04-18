def dp_b (n,m) :
    dp = [[1]*(m+1) for _ in range(m+1)]
    for i in range(2,m+1):
        dp[1][i]=i
    for i in range(2,n+1):
        for j in range(i+1,m+1):
            dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
    return dp[n][m]

for _ in range(int(input())):
    west, east =  map(int, input().split())
    print(dp_b(west,east))