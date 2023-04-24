A,B=map(int,input().split())
lis = []
for i in range(1,B+1):
    for I in range(i):
        lis.append(i)
print(sum(lis[A-1:B]))