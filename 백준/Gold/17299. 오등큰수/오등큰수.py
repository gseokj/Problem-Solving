from collections import Counter
n = int(input())
a =list(map(int,input().split()))
a_common=Counter(a)
stack=[]
result = [-1] * n

for i in range(n):
    while stack and a_common[a[i]]>a_common[a[stack[-1]]] :
        result[stack[-1]] = a[i]
        stack.pop()
    stack.append(i)
print(*result)