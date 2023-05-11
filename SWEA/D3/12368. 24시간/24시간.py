for x in range(1,int(input())+1):
    a, b = map(int,input().split())
    res = (a+b)%24
    print(f"#{x} {res}")
