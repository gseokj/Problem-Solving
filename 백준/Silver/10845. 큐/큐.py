from sys import stdin
T = int(stdin.readline())
que=[]
for i in range(T):
    A = list(stdin.readline().split())
    if A[0] == 'push' :
        que.append(A[1])
    elif A[0] == 'pop' :
        if len(que)!=0 :
            print(que[0])
            del que[0]
            
        else :
            print(-1)
    elif A[0] == 'empty' :
        if len(que)==0 :
            print(1)
        else :
            print(0)
    elif A[0] == 'size' :
        print(len(que))
    elif A[0] == 'front' :
        if len(que) == 0 :
            print(-1)
        else :
            print(que[0])
    
    elif A[0] == 'back' :
        if len(que) == 0 :
            print(-1)
        else :
            print(que[-1])