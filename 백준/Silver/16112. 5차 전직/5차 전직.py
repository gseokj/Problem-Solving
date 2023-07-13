import sys

n, k = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
count = 0
result = 0
for i in range(n):
    if count < k:
        count += 1
        result -= arr[i]
    result += arr[i] * count
print(result)