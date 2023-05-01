N=int(input())
expression=list(input())
num=[int(input()) for i in range(N)]

stack=[]
for i in expression :
    result = 0
    if i.isalpha() :
        stack.append(num[ord(i)-65])
    else :
        a = stack.pop()
        b = stack.pop()
        if i == '*' :
            result = a*b
        elif i == '+' :
            result = b+a
        elif i == '/':
            result  = b/a
        elif i == '-':
            result = b-a
        stack.append(result)
print('%.2f' %stack[-1])
        