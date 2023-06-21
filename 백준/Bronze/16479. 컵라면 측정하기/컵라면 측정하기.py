k=int(input())
d1,d2= map(int,input().split())
ans =k ** 2 - (((d1 - d2) / 2) ** 2)
if ans%1==0:
    print(int(ans))
else: 
    print(ans)