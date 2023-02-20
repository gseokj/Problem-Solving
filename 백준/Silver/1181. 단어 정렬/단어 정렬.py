T = int(input())
ls = []
for i in range(T):
    A = input()
    if A not in ls:
        ls.append(A)
ls.sort()
ls.sort(key=len)
for i in ls :
    print(i)