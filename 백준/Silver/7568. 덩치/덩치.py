#
result=""
A=[]
T = int(input())
for i in range(T):
    A.append(list(map(int,input().split())))
for i in A:
    cnt=0
    result = 1
    for j in A:
        if i[0] < j[0] and i[1] < j[1]:
            result += 1
        cnt+=1
    print(result,end=' ') 
    