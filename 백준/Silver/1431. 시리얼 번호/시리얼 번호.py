n = int(input())

def total(num):
    res = 0
    for i in num:
        if i.isdigit():
            res+=int(i)
    return res

arr = []
for i in range(n):
    a = input()
    arr.append(a)

arr.sort(key = lambda x:(len(x), total(x), x))
for i in arr:
    print(i)