for _ in range(int(input())):
    n=(int(input()))
    dp=[0,1,1,1,2]+[0]*n
    for i in range(5,n+1):
        dp[i]=(dp[i-1]+dp[i-5])
    print(dp[n])