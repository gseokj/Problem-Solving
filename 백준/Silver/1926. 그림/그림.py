from collections import deque
dr = [0,-1,0,1]
dc = [-1,0,1,0]

def bfs(xr,xc):
    q = deque()
    total_painting = 0
    max_painting = 0
    for i in range(xr):
        for j in range(xc):
            if graph[i][j] == 1 :
                graph[i][j] = 0
                q.append([i,j])
                cur_painting = 1
                total_painting += 1
            while q :
                ar,ac=q.popleft()
                for k in range(4):
                    nr = ar + dr[k]
                    nc = ac + dc[k]
                    if nr < 0 or nc < 0 or nr >= r or nc >= c :
                        continue
                    if graph[nr][nc] == 1 :
                        graph[nr][nc] = 0
                        cur_painting+=1
                        q.append([nr,nc])
                max_painting = max(max_painting,cur_painting)
    return total_painting,max_painting

r, c = map(int,input().split())
graph = [list(map(int,input().split())) for i in range(r)]
res= bfs(r,c)
print(res[0])
print(res[1])
