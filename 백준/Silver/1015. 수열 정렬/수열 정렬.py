T = int(input())
lis = list(map(int,input().split()))
result=[]

for i in range(T):
    result.append([i,lis[i]])
result.sort(key=lambda x: x[1])
for i in range(T):
    result[i].append(i)
result.sort()
for i in result:
    print(i[2],end = ' ')