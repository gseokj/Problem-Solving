
from collections import deque
dc = [-1,0,1,0]
dr = [0,1,0,-1]
def bfs(c,r):
    que = deque([(c,r)])
    while que:
        cr = que.popleft()
        temp_row = cr[1]
        temp_col = cr[0]
        field[temp_row][temp_col] = 0
        for i in range(4):
            nc = temp_col + dc[i]
            nr = temp_row + dr[i]
            if nc < 0 or nr < 0 or nc >= m or nr >= n :
                continue
            if field[nr][nc] == 1:
                que.append([nc,nr])
                field[nr][nc] = 0



for _ in range(int(input())):
    m, n, lettuces = map(int,input().split())
    field  = [[0] * m for _ in range(n)]
    cnt=0
    for _ in range(lettuces):
        c,r = map(int,input().split())
        field[r][c] = 1

    for r in range(n) :
        for c in range(m) :
            if field[r][c] == 1:
                bfs(c,r)
                cnt+=1
    print(cnt)
