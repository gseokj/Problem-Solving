import sys
sys.setrecursionlimit(10**9)
dx = [-1,1,0,0]
dy = [0,0,-1,1]
ans=False
def dfs(y,x):
    global ans
    
    if y == m-1:
        ans = True
        return True

    elect[y][x]=2
    for i in range(4):
        tx = x + dx[i]
        ty = y + dy[i]
        if 0<=ty<m and 0<=tx<n and elect[ty][tx]==0:
            dfs(ty, tx)
            
        
    

m, n = map(int,input().split())
elect=[]
for _ in range(m):
    elect.append(list(map(int,input())))
for i in range(n):
    if elect[0][i]==0:
        dfs(0,i)
        if ans:
            print('YES')
            break
if not ans:
    print('NO')