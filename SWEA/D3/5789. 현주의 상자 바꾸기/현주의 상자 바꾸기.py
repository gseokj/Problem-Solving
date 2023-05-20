for x in range(int(input())):
    N,Q = map(int,input().split())
    arr=[0]*(N+1)
    for i in range(Q):
        L,R = map(int,input().split())
        for j in range(L,R+1):
            arr[j] = i+1
    print(f"#{x+1}",*arr[1:])