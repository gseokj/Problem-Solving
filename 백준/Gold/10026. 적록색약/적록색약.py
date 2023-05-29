import sys
from collections import deque
input = sys.stdin.readline
dr=[0,-1,0,1]
dc=[-1,0,1,0]
def dfs(r,c) :
    q = deque()
    rgb =['R','G','B']
    cnt=0
    for xr in range(r):
        for xc in range(c):
            if graph[xr][xc] in rgb and visited[xr][xc] == False:
                q.append([xr, xc])
                cur = graph[xr][xc]
                cnt+=1
                while q :
                    ar,ac = q.popleft()
                    visited[ar][ac] = True
                    for i in range(4):
                        nr = ar + dr[i]
                        nc = ac + dc[i]
                        if nr < 0 or nc < 0 or nr>=r or nc>=c:
                            continue
                        elif graph[nr][nc] == cur and visited[nr][nc]==False:
                            visited[nr][nc] = True
                            q.append([nr,nc])

    return cnt

r = int(input())
c = r
graph = [list(input()) for _ in range(r)]
visited=[[False] * c for _ in range(r)]
print(dfs(r,c),end=' ')
for i in range(r):
    for j in range(c):
        if graph[i][j] == "R":
            graph[i][j] = "G"
visited=[[False] * c for _ in range(r)]
print(dfs(r,c))