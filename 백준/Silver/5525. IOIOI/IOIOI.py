import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
k = input()
s ="OI"
P = "IOI"+s*(n-1)
cnt=0
for i in range(m-len(P)+1):
    if P in k[i:i+len(P)]:
        cnt+=1
print(cnt)
