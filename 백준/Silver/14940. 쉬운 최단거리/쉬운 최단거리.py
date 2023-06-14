from collections import deque
import sys
input = sys.stdin.readline
d = [[1,0],[-1,0],[0,1],[0,-1]]
def bfs(y,x):  
    queue = deque()
    queue.append([y,x])
    visited[y][x] = 0
    while queue:
        r, c =  queue.popleft()
        for i in range(4):
            rr = r+d[i][0]
            cc = c+d[i][1]
            
            if (0<=rr<n) and (0<=cc<m) and visited[rr][cc] == -1: 
                if graph[rr][cc] == 0:
                    visited[rr][cc] = 0
                elif graph[rr][cc] == 1:
                    visited[rr][cc] = visited[r][c] +1
                    queue.append([rr,cc])

n, m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
visited = [[-1]*m for _ in range(n)]
for i in range(n):
    for k in range(m):
        if graph[i][k] == 2 and visited[i][k]== -1:
            bfs(i,k)
for i in range(n):
    for k in range(m):
        if graph[i][k] == 0:
            print(0, end= " ")
        else:
            print(visited[i][k], end = " ")
            
    print()