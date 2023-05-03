for x in range(1, int(input())+1):
    l,l2 = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    temp = []
    result = 0
    if len(a)>len(b) :
        temp = b
        b = a
        a = temp
    for i in range(len(b)-len(a)+1):
        total=0
        for j in range(len(a)):
            total+=a[j]*b[j+i]
        result = max(total,result)
    print(f"#{x} {result}")
        