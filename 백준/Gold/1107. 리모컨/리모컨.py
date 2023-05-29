import sys
input = sys.stdin.readline
m = int(input())
n = int(input())

arr = list(map(int,input().split()))
cur=100
cnt = abs(m-cur)
for i in range(1000001):
    num = str(i)
    for j in range(len(num)):
        if int(num[j]) in arr:
            break
        elif j == len(num)-1:
            cnt = min(cnt,abs(i-m)+len(num))
print(cnt)