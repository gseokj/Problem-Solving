k = int(input())
width = []
height = []
t = []
for i in range(6):
    dir, len = map(int, input().split())
    if dir == 1 or dir ==2:
        width.append(len)
        t.append(len)
    else:
        height.append(len)
        t.append(len)
h = t.index(max(height))
w = t.index(max(width))
small1 = abs(t[h-1] - t[(h-5 if h == 5 else h +1)])
small2 = abs(t[w-1] - t[(w-5 if w == 5 else w +1)])
print((max(height) * max(width) - small1 * small2) * k)