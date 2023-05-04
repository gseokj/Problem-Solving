T = int(input())
for i in range(1,T+1) :
    A = int(input())
    arr = sorted(list(map(int,input().split())))
    print(f"#{i}",end=' ')
    print(*arr)