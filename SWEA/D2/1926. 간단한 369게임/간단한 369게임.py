T = int(input())
arr=[]
for i in range(1,T+1) :
    result=''
    for j in str(i):
        sam = int(j)
        if sam % 3 == 0 and sam != 0:
            result+="-"
        else :
            result+=j
    arr.append(result)
for i in arr:
    if "-" in i :
        print(i.count("-")*"-",end=' ')
    else :
        print(i,end=' ')

