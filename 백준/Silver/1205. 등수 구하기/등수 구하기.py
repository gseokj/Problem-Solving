n,score,rank = map(int,input().split())

if n > 0 :
    lis = list(map(int,input().split()))
    if n == rank and lis[-1] >= score:
        print(-1)
    else :
        cnt = n+1
        for i in range(n):
            if lis[i] <= score:
                cnt = i+1
                break
        print(cnt)
else :
    print(1)