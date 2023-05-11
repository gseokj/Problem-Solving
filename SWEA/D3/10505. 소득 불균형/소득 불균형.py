for x in range(1,int(input())+1):
    l = int(input())
    income = list(map(int,input().split()))
    avg = sum(income)/l
    res = 0
    for i in income:
        if avg>=i :
            res+=1
    print(f"#{x} {res}")
