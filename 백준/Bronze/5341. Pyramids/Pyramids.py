while 1:
    a=int(input())
    if a == 0:
        break
    res=0
    for i in range(1,a+1):
        res+=i
    print(res)