import sys

input = sys.stdin.readline

n, k = map(int,input().split())
lis = list(map(int,input().split()))

s = 0
e = max(lis)
while s <= e :
    mid = (s+e)//2
    sum = 0
    for i in lis :
        if i > mid :
            sum += i - mid
    if sum >=k:
        s = mid+1
    else :
        e = mid-1
print(e)