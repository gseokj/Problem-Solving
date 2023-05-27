from collections import deque

def bfs (n):
    q = deque()
    q.append(n)
    while q :
        x = q.popleft()
        if x==k:
            print(dots[x])
            break
        for i in (x-1,x+1,x*2) :
            if 0 <= i <= 100000 and not dots[i]:
                dots[i] = dots[x] +1
                q.append(i)

dots = [0] * 100001
n,k = map(int,input().split())

bfs(n)