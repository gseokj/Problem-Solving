for x in range(1,11):
    input()
    arr=[list(map(int,input().split())) for _ in range(100)]
    res=0
    n=100
    for i in range(n):
        total=0
        for j in range(n):
            total+=arr[i][j]
        res=max(res,total)
        
    for i in range(n):
        total=0
        for j in range(n):
            total+=arr[j][i]
        res=max(res,total)
    total=0
    for i in range(n):
        total+=arr[i][i]
    res=max(res,total)
    for i in range(n-1,-1,-1):
        total+=arr[i][i]
    print(f"#{x}",res)