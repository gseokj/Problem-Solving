n,m = map(int,input().split())
p = [0,0]
s = 0
for i in range(n):
    r = list(map(int,input().split()))
    for j in range(m):
        if r[j]:
            p[s] = [i,j]
            s ^=1
print(abs(p[0][0]-p[1][0])+abs(p[0][1]-p[1][1]))