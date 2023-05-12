for x in range(1,int(input())+1):
    arr = list(map(int,input().split()))
    res = 0
    for i in arr:
        if i >= 40 :
            res+=i
        else :
            res+=40
    res = res//len(arr)
    print(f"#{x} {res}")