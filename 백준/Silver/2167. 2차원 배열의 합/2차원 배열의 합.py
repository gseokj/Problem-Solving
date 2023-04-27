n,m = map(int,input().split())
matrix = [list(map(int,input().split())) for _ in range(n)]
for _ in range(int(input())):
    sum=0
    i,j,x,y=map(int,input().split())
    for a in range(i-1,x):
        for b in range(j-1,y):
            sum+=matrix[a][b]
    print(sum)