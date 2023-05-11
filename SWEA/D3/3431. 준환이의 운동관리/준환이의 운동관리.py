for i in range(1,int(input())+1):
    L,U,X = map(int,input().split())
    res=0
    if X > U :
    	res = -1
    elif X>=L and X<= U:
        res = 0
    else :
        res = L-X
    print(f"#{i} {res}")
