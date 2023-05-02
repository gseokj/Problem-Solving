st=input()
res = []
for i in range(len(st)):
    res.append(st[i:len(st)])
res.sort()
for i in res:
    print(i)