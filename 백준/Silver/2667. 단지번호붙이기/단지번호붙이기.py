from collections import deque
dr = [0, -1, 0, 1]
dc = [-1, 0, 1, 0]


def bfs(houses, xr, xc):
    r = len(houses)
    c = len(houses[0])
    q = deque()
    q.append([xr, xc])
    houses[xr][xc] = 0
    cnt = 1

    while q:
        xr, xc = q.popleft()
        for i in range(4):
            nr = xr + dr[i]
            nc = xc + dc[i]
            if nr < 0 or nc < 0 or nr >= r or nc >= c:
                continue
            if houses[nr][nc] == 1:
                houses[nr][nc] = 0
                q.append([nr, nc])
                cnt += 1

    return cnt


n = int(input())
houses = []
for _ in range(n):
    row = list(map(int, input()))
    houses.append(row)

danji = []
for i in range(n):
    for j in range(n):
        if houses[i][j] == 1:
            cnt = bfs(houses, i, j)
            danji.append(cnt)

danji.sort()
print(len(danji))
for cnt in danji:
    print(cnt)
