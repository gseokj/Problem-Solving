for x in range(1,int(input())+1):
    n = int(input())
    t=[]
    a=[[0]*n for i in range(n)] # 90도
    b=[[0]*n for i in range(n)] # 180도
    c=[[0]*n for i in range(n)] # 270도
    
    for i in range(n):
        t.append(list(map(int,input().split())))
        
    for i in range(n):
        for j in range(n):
            a[i][j] = t[n-1-j][i]
    for i in range(n):
        for j in range(n):
            b[i][j] = a[n-1-j][i]
    for i in range(n):
        for j in range(n):
            c[i][j] = b[n-1-j][i]
    print(f"#{x}")
    for i in range(n):
        print(''.join(map(str,a[i])),''.join(map(str,b[i])),''.join(map(str,c[i])))
            
    
        
    