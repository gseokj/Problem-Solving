while(1):
    A=list(map(int,input().split()))
    if(A[0]==0 & A[1]==0 & A[2] ==0):
        break
    A=sorted(A)
    if A[0]**2+A[1]**2 == A[2]**2 :
        print("right")
    else :
        print("wrong")