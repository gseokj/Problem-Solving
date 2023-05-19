for _ in range(10):
    T = int(input())
    a=[input() for i in range(100)]
    a2=[]
    result=0
    for i in range(100):
        temp = ''
        for j in range(100):
            temp+=a[j][i]
        a2.append(temp)

    for x in a:
        for i in range(len(x)):
            for j in range(i,len(x)+1):
                if x[i:j] == x[i:j][::-1] :
                    result = max(result,len(x[i:j]))
    for x in a2:
        for i in range(len(x)):
            for j in range(i,len(x)+1):
                if x[i:j] == x[i:j][::-1] :
                    result = max(result,len(x[i:j]))
    print(f"#{T}",result)

