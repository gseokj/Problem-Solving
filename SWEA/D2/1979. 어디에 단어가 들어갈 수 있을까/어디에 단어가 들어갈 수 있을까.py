
# 행부터
for x in range(1,int(input())+1):
    result = 0
    n,k = map(int,input().split())
    a= [[] for _ in range(n)]
    for i in range(n):
        a[i] = list(map(int,input().split()))
        
    for row in range(n):
        cnt=0
        for col in range(n):
            if a[row][col]==1:
                cnt+=1
            else :
                if cnt==k:
                    result+=1
                cnt=0
        if cnt==k:
            result+=1
    # 열부터
    for row in range(n):
        cnt=0
        for col in range(n):
            if a[col][row]==1:
                cnt+=1

            else :
                if cnt==k:
                    result+=1
                cnt=0
        if cnt==k:
            result+=1
    print(f"#{x} {result}")