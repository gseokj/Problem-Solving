import sys
 
input = sys.stdin.readline
n,k = map(int,input().split())
dong =[]
cnt=0
for _ in range(n):
    dong.append(int(input()))
for i in range(n-1,-1,-1):
    while 1:
        if k-dong[i]>=0:
            cnt+=1
            k-=dong[i]
        else :
            break
print(cnt)