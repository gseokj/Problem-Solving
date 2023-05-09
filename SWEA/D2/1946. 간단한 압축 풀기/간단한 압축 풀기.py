for x in range(1,int(input())+1):
    T = int(input())
    arr=''
    for _ in range(T):
        a,b = input().split()
        arr+=a*int(b)
    print(f"#{x}")
    for i,j in enumerate(arr):
        print(j,end='')
        if i % 10 == 9:
            print()
    print()
