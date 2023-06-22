from collections import Counter
x,y =[],[]
for _ in range(3):
    a,b = map(int,input().split())
    x.append(a)
    y.append(b)
x=Counter(x).most_common()
y=Counter(y).most_common()
print(f"{x[-1][0]} {y[-1][0]}")