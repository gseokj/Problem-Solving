for _ in range(int(input())):
    floor=int(input())
    hosu=int(input())
    dp = [[0]*(hosu+1) for i in range(floor+1)]
    for i in range(floor+1):
        dp[i][1] = 1
    for i in range(hosu+1):
        dp[0][i] = i
    for i in range(1,floor+1):
        for j in range(2,hosu+1):
            dp[i][j] = dp[i-1][j]+dp[i][j-1]
    print(dp[floor][hosu])
