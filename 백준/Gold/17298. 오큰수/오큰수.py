N = int(input())
lis = list(map(int,input().split()))
result = [-1] * N
stack = []
for i in range(N):
    while stack and lis[i]>lis[stack[-1]]:
        result[stack[-1]]=lis[i]
        stack.pop()
    stack.append(i)
print(*result)