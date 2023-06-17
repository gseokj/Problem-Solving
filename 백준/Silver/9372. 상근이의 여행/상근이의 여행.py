import sys
input = sys.stdin.readline
def dfs(node, cnt):
    visited[node] = 1
    for i in graph[node]:
        if visited[i] == 0:
            cnt = dfs(i, cnt + 1)
    return cnt
T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    visited = [0] * (N + 1)
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    print(dfs(1, 0))