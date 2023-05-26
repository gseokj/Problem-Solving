import sys
input = sys.stdin.readline
def dfs(v):
    visit[v] = 1

    for i in range(1,n+1):
        if visit[i] == 0 and graph[v][i] == 1:
            dfs(i)

n,m =map(int,input().split())
graph = [[0] *(n+1) for i in range(n+1)]
for i in range(m):
    a,b = map(int,input().split())
    graph[b][a] =1
    graph[a][b] = 1
visit = [0] * (n+1)

cnt=0
for i in range(1,n+1):

    if visit[i] == 0 :
        dfs(i)
        cnt+=1
print(cnt)

