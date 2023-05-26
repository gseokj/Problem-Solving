import sys
N=int(input())
papers = [list(map(int,input().split())) for _ in range(N)]
white=0
blue =0
def color_paper(N,r,c):
    global white,blue
    cur = papers[r][c]
    for i in range(r,r+N):
        for j in range(c,c+N):
            if cur != papers[i][j]:
                color_paper(N//2,r, c)
                color_paper(N//2,r, c+N//2)
                color_paper(N//2,r+N//2, c)
                color_paper(N//2,r+N//2, c+N//2)
                return
    if cur == 0 :
        white+=1
    else :
        blue+=1

color_paper(N,0,0)
print(white)
print(blue)