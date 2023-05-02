from math import factorial
A = str(factorial(int(input())))
cnt=0
for i in range(1,len(A)+1):
    if A[-i] != "0":
        break
    cnt+=1
print(cnt)