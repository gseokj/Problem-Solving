import sys
input = sys.stdin.readline
def dp_test (n):
    for i in range(1,n):
        arr[i] = max(arr[i],arr[i-1]+arr[i])
    return max(arr)
while 1 :
    n = int(input())
    if n == 0:
        break
    arr = [int(input()) for _ in range(n)]
    print(dp_test(n))