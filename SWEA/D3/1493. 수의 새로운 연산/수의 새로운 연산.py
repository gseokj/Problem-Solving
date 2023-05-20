for x in range(int(input())):
    a,b=map(int,input().split())
    x1,y1=0,0
    res=0
    n=400
    flag=0
    dp = [[0] * n for i in range(n)]
    dp[1][1] = 1
    cnt=0
    for i in range(2,n):
        cnt += 1
        dp[i][1] = cnt + dp[i-1][1]
    cnt=1
    for i in range(2,n):
        cnt+=1
        dp[1][i] = cnt + dp[1][i-1]
    for i in range(2,n):
        for j in range(2,n):
            dp[i][j] =  (dp[i-1][j]*2) - dp[i-1][j-1]
    for i in range(n):
        for j in range(n):
            if a==dp[i][j] or b==dp[i][j]:
                x1+=i
                y1+=j
                flag+=1

    print(f"#{x+1}",dp[x1][y1] if flag ==2 else dp[x1*2][y1*2] )