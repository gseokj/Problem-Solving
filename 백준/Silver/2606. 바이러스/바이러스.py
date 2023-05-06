
def dfs(v):
    visited[v] = 1
    for i in range(1,N+1):
        if visited[i] == 0 and graph[v][i]:
            dfs(i)



N = int(input())
graph = [[0] * (N+1) for i in range(N+1)]
M= int(input())
for _ in range(M):
    a,b = map(int,input().split())

    graph[a][b] = graph[b][a] = 1
visited = [0] * (N+1)
dfs(1)
print(visited.count(1)-1)

