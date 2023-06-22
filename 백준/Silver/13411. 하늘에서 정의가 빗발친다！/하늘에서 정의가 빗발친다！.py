import sys
input=sys.stdin.readline
T=int(input())
a=[]
for i in range(1,T+1):
    x,y,v=map(int,input().split())
    d = (x**2+y**2)**0.5
    a.append((d/v,i))
a.sort(key=lambda x:(x[0],x[1]))
for i in range(T):
    print(a[i][1])