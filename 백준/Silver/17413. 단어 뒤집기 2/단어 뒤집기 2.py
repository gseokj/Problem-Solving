from collections import deque
a = input()+'\n'
flag = False
stack = deque()
result = ''
for i in a:
    if not flag :
        if i == '\n' or i == ' ':
            while stack:
                result+=stack.pop()
            result+=" "
         
        else :
            if i == "<":
                while stack:
                    result+=stack.pop()
                flag = True
            stack.append(i)    
    else :
        flag = True
        stack.append(i)
        if i == ">":
            for j in range(len(stack)):
                result+=stack.popleft()
            flag = False
print(result)