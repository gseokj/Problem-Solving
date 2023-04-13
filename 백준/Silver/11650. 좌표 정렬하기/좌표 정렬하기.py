A=int(input())
dot = []
for _ in range(A):
    x, y = map(int,input().split())
    dot.append([x,y])
for i in sorted(dot):
    print(i[0],i[1])