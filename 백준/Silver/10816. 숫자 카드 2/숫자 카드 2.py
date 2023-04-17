m = int(input())
sang = list(map(int,input().split()))
n = int(input())
f = list(map(int,input().split()))
c={}
for i in sang :
    if i in c :
        c[i] += 1
    else :
        c[i] = 1
        
for j in f:
    if j in c :
        print(c[j],end=' ')
    else :
        print(0,end=' ')