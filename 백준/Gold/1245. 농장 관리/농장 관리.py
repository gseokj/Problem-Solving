def dfs(a, b):
    dx = [1, -1, 0, 0, 1, 1, -1, -1]
    dy = [0, 0, 1, -1, 1, -1, -1, 1]
    global trigger
    visited[a][b] = True
    for i in range(8):
        x = a + dx[i]
        y = b + dy[i]
        if -1 < x < n and -1 < y < m:
            if graph[a][b] < graph[x][y]:
                trigger = False
            if not visited[x][y] and graph[x][y] == graph[a][b]:
                dfs(x, y)
n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
cnt = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] > 0 and not visited[i][j]:
            trigger = True
            dfs(i, j)
            if trigger:
                cnt += 1
print(cnt)