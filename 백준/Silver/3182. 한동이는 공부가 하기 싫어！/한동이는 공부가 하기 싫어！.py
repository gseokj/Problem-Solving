import sys
input = sys.stdin.readline
def dfs (v, cnt):
    visited[v] = 1
    for i in range(1,N+1):
        if visited[i] == 0 and graph[v][i] == 1:
            cnt = dfs(i,cnt+1)
    return cnt
N = int(input())
graph = [[0] * (N+1) for i in range(N+1)]
for i in range (1,N+1):
    T = int(input())
    graph[i][T] = 1
result = []
for i in range(1,N+1):
    visited = [0] * (N + 1)
    result.append(dfs(i,1))
print(result.index(max(result))+1)