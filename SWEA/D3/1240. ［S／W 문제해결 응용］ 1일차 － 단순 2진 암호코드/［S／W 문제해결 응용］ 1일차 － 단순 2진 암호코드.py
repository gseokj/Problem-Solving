for x in range(int(input())):
    n,m = map(int,input().split())
    a=''
    for i in range(n):
        a+= input()
    for i in range(len(a)):
        if a[i] == "1":
            a=a[i:i+56]
            break
    while a[-1] == "0" :
        a="0"+a[:-1]
    arr={"0001101":0,"0011001":1,"0010011":2,"0111101":3,"0100011":4,"0110001":5,"0101111":6,"0111011":7,"0110111":8,"0001011":9}
    total=0
    lis = []
    for i in range(0,50,7):
        t = arr[a[0 + i:7 + i]]
        if i % 2:
            total+=t
            lis.append(t)
        else :
            total+=t * 3
            lis.append(t)
    if total % 10 != 0 :
        total=0
    else :
        total=sum(lis)
    print(f"#{x+1}",total)