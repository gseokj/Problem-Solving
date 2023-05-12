for x in range(1,11) :
    input()
    arr=list(input().split(" "))
    input()
    a=list(input().split(" "))
    flag = 0
    for i,j in enumerate(a):
        if flag :
            flag-=1
            continue
        if j == "I" :
            flag = int(a[i+2])+2
            for k in range(int(a[i+2])-1,-1,-1):
                arr.insert(int(a[i+1]),a[i+3+k])
        elif j == "D":
            flag = 2
            for _ in range(int(a[i+2])):
                arr.pop(int(a[i+1]))
        elif j == "A":
            flag = int(a[i+1])+1
            for k in range(int(a[i + 1])-1,-1,-1):
                arr.append(a[i + 2 + k])
    print(f"#{x}",end=' ')
    print(*arr[:10])