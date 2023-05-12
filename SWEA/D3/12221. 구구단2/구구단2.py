for x in range(1,int(input())+1):
    a,b = map(int,input().split())
    if a > 9 or b > 9 :
        print(f"#{x} -1")
    else :
        print(f"#{x} {a*b}")
