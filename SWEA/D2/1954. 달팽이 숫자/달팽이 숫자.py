for x in range(1,int(input())+1):
    n = int(input())
    snail = [[0] * n for _ in range(n)]
    dr = [0,1,0,-1]
    dc = [1,0,-1,0]
    r,c=0,0
    v=0

    for i in range(1,n*n+1):
        snail[r][c] = i
        r+=dr[v]
        c+=dc[v]
        if r<0 or c<0 or r>=n or c>=n or snail[r][c] != 0:
            r -= dr[v]
            c -= dc[v]
            v=(v+1) % 4
            r += dr[v]
            c += dc[v]
    print(f"#{x}")
    for i in snail:
        print(*i)

