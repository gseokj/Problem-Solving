for x in range(1,int(input())+1):
    t,k = map(int,input().split())
    a=[]
    hakjum=["","A+","A0","A-","B+","B0","B-","C+","C0","C-","D"]
    for i in range(1,t+1):
        arr=list(map(int,(input().split())))
        a.append([arr[0]*0.35+arr[1]*0.45+arr[2]*0.2])
    k_score = a[k-1]
    a.sort(reverse=True)
    t=t//10
    print(f"#{x} {hakjum[a.index(k_score) // t+1]}")
