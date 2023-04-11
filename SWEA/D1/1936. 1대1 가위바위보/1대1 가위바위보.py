A,B =map(int,input().split())

# 1=가위 2=바위 3=보 비기는 경우는 없다.
# A가 이기는 경우 1,3 2,1 3,2
# B가 이기는 경우 3,1 1,2 2,3

if (A==1 and B== 3) | (A==2 and B== 1) | (A==3 and B== 2) :
    print("A")
else:
    print("B")
