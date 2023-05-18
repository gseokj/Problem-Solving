for x in range(int(input())):
    a = []
    for i in range(int(input())):
        a.append(list(map(int,list(input()))))
    mid = len(a)//2
    mid2 = mid+1
    total=0
    for i in range(len(a)):
        total+=sum(a[i][mid:mid2])
        if i < len(a)//2 :
            mid+=-1
            mid2+=1
        else :
            mid+=1
            mid2 += -1
    print(f"#{x+1}",total)