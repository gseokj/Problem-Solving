import sys
input = sys.stdin.readline
def dp(n):
    if n == 0:
        return 0
    elif n > 0:
        dp_list = [0, 1]
        for i in range(2, n + 1):
            dp_list.append((dp_list[i - 1] + dp_list[i - 2]) % 1000000000)
        return dp_list[n]
    else:
        dp_list = [0, 1, -1]
        for i in range(3, -n + 1):
            dp_list.append((dp_list[i - 2] - dp_list[i - 1]) % 1000000000)
        return dp_list[-n]

n = int(input())
res = [0, 0]
res[1] = dp(abs(n))
if n > 0:
    res[0] = 1
elif n < 0:
    if abs(n) % 2 == 0:
        res[0] = -1
    else:
        res[0] = 1
else:
    res[0] = 0

print(res[0])
print(abs(res[1]))
