A = input()
result = 0
for i in range(int(A)+1):
    target=sum(map(int,str(i)))+i
    if target == int(A) :
        result=i
        break
    
print(result)