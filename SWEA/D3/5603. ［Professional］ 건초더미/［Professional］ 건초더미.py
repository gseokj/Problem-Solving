for x in range(int(input())):
    arr=[]
    res=0
    N = int(input())
    for i in range(N):
        arr.append(int(input()))
    avg = sum(arr)//N
    for i in arr:
       if avg > i :
           res+=avg-i
    print(f"#{x+1}",res)