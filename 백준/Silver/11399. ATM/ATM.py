n=int(input())
b=sorted(list(map(int,input().split())))
total = 0
result =0
for i in b:
    total+=i
    result+=total
print(result)