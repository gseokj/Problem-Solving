def dp_test(n):
    dp = [0] * 1000

    dp[1] = 1
    dp[2] = 2
    for i in range(3, 1000):
        dp[i] = dp[i - 1] + dp[i - 2]
    return dp

arr = dp_test(1000)
while 1:
    a,b=map(int,input().split())
    if a == 0  and b == 0:
        break
    cnt = 0
    for i in range(1,1000):
        if a <= arr[i] and arr[i] <= b:
            cnt+=1
    print(cnt)