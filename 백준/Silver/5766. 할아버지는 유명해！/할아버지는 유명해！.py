from collections import Counter
while 1:
    a=[]
    res=[]
    n,m = map(int,input().split())
    if n == 0 and m == 0 :
        break
    for i in range(n):
        a.extend(map(int,input().split()))
    b = Counter(a).most_common()
    for i in range(len(b)):
        if b[1][1] == b[i][1] :
            res.append(b[i][0])
    print(*sorted(res))