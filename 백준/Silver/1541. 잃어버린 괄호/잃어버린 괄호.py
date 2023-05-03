a = list(input().split('-'))
result=0
for i in range(1,len(a)):
    result+=sum(map(int,a[i].split("+")))
print(sum(map(int,a[0].split("+")))-result)