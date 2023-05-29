import sys
from collections import deque
dr=[0,-1,0,1]
dc=[-1,0,1,0]
def bfs():
    q = deque()
    xr=0
    xc=0
    q.append([xr,xc])
    while q:
        xr,xc = q.popleft()
        for i in range(4):
            nr = dr[i] + xr
            nc = dc[i] + xc
            if nr == r-1 and nc == c-1 :
                maze[nr][nc] = maze[xr][xc]+1
                return
            elif nr < 0 or nc < 0 or nr>=r or nc>=c:
                continue
            else :
                if maze[nr][nc] == 1:
                    maze[nr][nc] += maze[xr][xc]
                    q.append([nr,nc])






r,c =map(int,input().split())
maze = [list(map(int,input())) for _ in range(r)]
bfs()
print(maze[r-1][c-1])
