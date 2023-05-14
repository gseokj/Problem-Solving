def solution(dp):
    for i in range(len(dp)-2,-1,-1) :
        for j in range(i+1) :
            dp[i][j] = max(dp[i][j] + dp[i+1][j],dp[i][j] + dp[i+1][j+1])
    return dp[0][0]