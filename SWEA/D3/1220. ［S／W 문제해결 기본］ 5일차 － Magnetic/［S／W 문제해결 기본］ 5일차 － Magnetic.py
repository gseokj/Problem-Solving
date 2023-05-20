for x in range(1,11):
    T = int(input())
    arr=[]
    arr2=[]
    res=0
    for i in range(T):
        arr.append(input().split())
    for i in range(100):
        temp=''
        for j in range(100):
            temp+=arr[j][i]
        arr2.append(temp)
    for i in arr2:
        res+=i.replace("0","").count("12")

    print(f"#{x}",res)
