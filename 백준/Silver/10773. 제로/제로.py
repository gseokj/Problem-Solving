stack = []
for _ in range(int(input())):
    comm = int(input())
    if comm == 0 :
        if stack :
            stack.pop()
    else :
        stack.append(comm)
print(sum(stack))