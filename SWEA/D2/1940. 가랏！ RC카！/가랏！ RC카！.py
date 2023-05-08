for x in range(1,int(input())+1):
    n =int(input())
    result = 0
    cur = 0
    for i in range(n):
        v = list(map(int,input().split()))
        if v[0] == 1 :
            cur+=v[1]
            result += cur
        elif v[0] == 2 :
            if cur-v[1] <= 0  :
                cur = 0
            else :
                cur-=v[1]
            result += cur
        else :
            result += cur
    print(f"#{x} {result}")

