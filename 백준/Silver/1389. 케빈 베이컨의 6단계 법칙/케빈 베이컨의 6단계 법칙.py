from collections import deque
def bfs(v):
    visited[v] =True
    bacon = 0
    total_bacon = 0
    que = deque()
    que.append((v,bacon))
    while que :
        node,bacon = que.popleft()
        total_bacon+=bacon
        for i in graph[node]:
            if visited[i] == False :
                visited[i] = True
                que.append((i,bacon+1))
    return total_bacon





n,m = map(int,input().split())

graph =[[]*(n+1) for _ in range(n+1)]

for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
visited = [False] * (n+1)
min_bacon=999999
res = 0
min_bacon = 999999
for i in range(1,1+n):
    visited = [False] * (n + 1)
    t=bfs(i)
    if min_bacon > t:
        min_bacon = t
        res = i
print(res)