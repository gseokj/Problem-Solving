for x in range (1,11):
    l, a = input().split()
    a = list(a)
    flag = True
    while flag :
        for i in range(len(a)-1):
            if a[i] == a[i+1] :
                a.pop(i)
                a.pop(i)
                break
        else :
            flag=False
    a = ''.join(a)
    print(f"#{x} {a}")