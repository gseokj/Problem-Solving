N = int(input())
A = list(map(int,input().split()))
M = int(input())
target_list = list(map(int,input().split()))
A.sort()

for target in target_list:
    s, e = 0, N-1
    isExist = False
    while s <= e :
        mid = (s + e) //2
        if target == A[mid]:
            isExist = True
            print(1)
            break
        elif target > A[mid]:
            s = mid +1
        else :
            e = mid -1
    else :
        if not isExist :
            print(0)