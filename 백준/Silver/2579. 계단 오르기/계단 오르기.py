def dp_test(n,arr):

    dp = [0] * 301
    dp[1] = arr[1]
    dp[2] = arr[1]+arr[2]
    dp[3] = max(arr[2]+arr[3],arr[1]+arr[3])

    for i in range(4,n+1):
        dp[i] = max(dp[i-2]+arr[i],arr[i]+arr[i-1]+dp[i-3])
    return dp[n]

n = int(input())
arr=[0] * 301
for i in range(1,n+1):
    arr[i] = (int(input()))
print(dp_test(n,arr))