import sys
input = sys.stdin.readline
s,k = map(int,input().split())
q=s//k
r=s%k
n=1
while k:
    if r>0:
        n*=(q+1)
        r-=1
    else:
        n*=q
    k-=1
print(n)