for x in range(int(input())):
    input()
    a=input().split()
    l = len(a)//2
    if len(a)%2:
        l+=1
    a1=a[:l]
    a2=a[l:]+[0]
    res=[]
    for i in range(l):
        res.append(a1[i])
        if a2[i]:
            res.append(a2[i])
    print(f"#{x+1}",*res)