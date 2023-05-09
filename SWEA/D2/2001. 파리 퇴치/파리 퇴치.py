for x in range(1,int(input())+1):
    n,m = map(int,input().split())
    arr=[]
    for _ in range(n):
        arr.append(list(map(int,input().split())))
    fly=0
    for i in range(n-m+1):
        for j in range(n-m+1):
            kill=0
            for k in range(m) :
                for l in range(m):
                    kill+=arr[i+k][j+l]
            fly=max(fly,kill)
    print(f"#{x} {fly}")