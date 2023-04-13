def solution(s):
    stack = [] 
    for i in s :
        if i == '(':
            stack.append(i)
        elif i == ')' :
            if stack :
                stack.pop()
            else :
                return False
                break
    if len(stack) != 0:
        return False
    else :
        return True