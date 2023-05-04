import sys
 
input = sys.stdin.readline
n,m = map(int,input().split())
lis = list(map(int,input().split()))
hap=[0]
total=0
for i in range(n):
    total+=lis[i]
    hap.append(total)
for _ in range(m):
    result=0
    a,b = map(int,input().split())
    print(hap[b]-hap[a-1])
