
def dp_test(n,arr):
    dp = [1] * n
    for i in range(n):
        for j in range(i):
            if arr[i] > arr[j] :
                dp[i] = max(dp[i],dp[j]+1)
    return dp
n=int(input())
arr=list(map(int,input().split()))
dp=dp_test(n,arr)
x = max(dp_test(n,arr))
print(x)

result = []
for i in range(n-1, -1, -1):
    if dp[i] == x:
        result.append(arr[i])
        x -= 1
print(*result[::-1])