for x in range(1,int(input())+1):
    a = int(input())
    
    flag ='1'
    cnt=1
    for i in str(a):
        if flag==i :
            continue
        else :
            flag=i
            cnt+=1
    print(f"#{x} {cnt}")


