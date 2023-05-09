def dp_test(n):
    dp = [[0]*11 for i in range(11)]
    dp[0][0] = 1
    dp[1][0] = 1
    dp[1][1] = 1
    for i in range(2, 11):
        for j in range(0,i+1):
            if j==0 :
                dp[i][j] = 1
            else :
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
    return dp[:n]
for x in range(1,int(input())+1):
    n = int(input())
    a =dp_test(n)
    print(f"#{x}")
    for i in a:
        for j in i:
            if j!=0 :
                print(j,end=' ')
        print()
