T=int(input())
for i in range(1,T+1) :
    A = list(map(int,input().split()))
    result = int(round(sum(A)/len(A)))
    print(f"#{i}",result)
    


