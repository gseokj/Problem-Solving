for x in range(int(input())):
    a=list(map(int,input().split()))
    print(f"#{x+1}",[a[i] for i in range(3) if a.count(a[i])==1 or a.count(a[i])==3][0])