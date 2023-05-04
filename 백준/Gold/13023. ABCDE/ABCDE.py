import sys

input = sys.stdin.readline

def dfs(v, cnt):
    if cnt == 4:
        print(1)
        sys.exit()
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(i, cnt+1)
    visited[v] = False

n, m = map(int, input().split())
graph = [[] for _ in range(n)]
for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(n):
    visited = [False] * n
    dfs(i, 0)

print(0)