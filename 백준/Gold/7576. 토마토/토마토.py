from collections import deque
dr=[0,-1,0,1]
dc=[-1,0,1,0]
def bfs(r,c):
    global cnt
    tomato=0
    total=r*c
    q = deque()
    for i in range(r):
        for j in range(c):
            if field[i][j] == 1:
                q.append([i, j])
                tomato += 1
            elif field[i][j] == -1:
                total -=1

    while q:
        cnt += 1
        for _ in range(len(q)):
            x = q.popleft()
            nr = x[0]
            nc = x[1]

            for i in range(4):
                xr = nr+dr[i]
                xc = nc+dc[i]
                if xr < 0 or xc < 0 or xr >= r or xc >= c :
                    continue
                else :
                    if field[xr][xc] == 0 :
                        field[xr][xc] = 1
                        q.append([xr,xc])
                        tomato+=1
    if tomato==total:
        return cnt
    else :
        return -1




c,r=map(int,input().split())
field = [list(map(int,input().split())) for _ in range(r)]
cnt=-1
print(bfs(r,c))
