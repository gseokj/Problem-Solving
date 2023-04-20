N = int(input())
cnt = 1
stack = []
result=[]
flag = True
for _ in range(N) :
    K = int(input())
    while cnt <= K :
        stack.append(cnt)
        result.append("+")
        cnt +=1
    if stack[-1]==K :
        stack.pop()
        result.append("-")
        
    else :
        print("NO")
        flag = False
        break
if flag :
    for i in result:
        print(i)
        