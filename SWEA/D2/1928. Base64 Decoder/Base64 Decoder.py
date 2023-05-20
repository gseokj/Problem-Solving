for x in range(int(input())):
    B='ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/'
    T=input()
    a=''
    temp=[]
    res=''
    for i in T:
        num = B.index(i)
        a+=bin(num)[2:].zfill(6)

    for i in range(0,len(a)-7,8):
        temp.append(a[i:i+8])

    for i in temp:
        res+=chr(int(i,2))
    print(f"#{x+1}",res)