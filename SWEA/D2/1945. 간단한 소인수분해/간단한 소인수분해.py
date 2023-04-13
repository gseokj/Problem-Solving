T = int(input())
# 소수인 수2,3,5,7,11

for i in range(1,T+1):
    result=[0,0,0,0,0]
    A = int(input())
    while A!=1 :
        if A % 2 == 0:
            A = A//2
            result[0]+=1
        elif A % 3 == 0:
            A = A//3
            result[1]+=1
        elif A % 5 == 0:
            A = A//5
            result[2]+=1
        elif A % 7 == 0:
            A = A//7
            result[3]+=1
        elif A % 11 == 0:
            A = A//11
            result[4]+=1
        else :
            break
    print(f"#{i}"," ".join(map(str,result)))