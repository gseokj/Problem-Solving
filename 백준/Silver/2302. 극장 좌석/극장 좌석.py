def count_ways(n, m, default):
    dp = [[0] * 2 for _ in range(n + 1)]

    dp[1][0] = 1
    dp[1][1] = 0

    for d in default:
        dp[d][1] = -1

    for i in range(2, n + 1):
        if dp[i][1] == -1:
            if dp[i - 1][1] != -1:
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
                dp[i][1] = -1
            else:
                dp[i][0] = dp[i - 1][0]
                dp[i][1] = -1
        else:
            if dp[i - 1][1] != -1:
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
                dp[i][1] = dp[i - 1][0]
            else:
                dp[i][0] = dp[i - 1][0]
                dp[i][1] = 0

    if dp[n][1] == -1:
        return dp[n][0]
    else:
        return dp[n][0] + dp[n][1]

n = int(input())
m = int(input())
default = [int(input()) for _ in range(m)]

result = count_ways(n, m, default)
print(result)