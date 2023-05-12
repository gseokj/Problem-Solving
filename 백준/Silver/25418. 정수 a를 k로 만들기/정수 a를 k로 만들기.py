a, k = map(int,input().split())
res = 0
while 1 :
    if a==k :
        break
    elif k % 2== 0 and k>= a*2  :
        k= k//2
        res+=1
    else :
        k-=1
        res+=1
print(res)