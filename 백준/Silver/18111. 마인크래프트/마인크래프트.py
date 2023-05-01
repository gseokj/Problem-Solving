n,m,b = map(int,input().split())
blocks =[]
for _ in range(n):
    blocks.append(list(map(int,input().split())))
height=0
min_time = 999999999
for i in range(257):
    use = 0
    take = 0
    time = 0
    for j in range(n):
        for k in range(m):
            if blocks[j][k] > i :
                 take += blocks[j][k]-i
            else :
                use += i-blocks[j][k]
    if use>take + b :
        continue
    time = use+ take*2
    if min_time >= time :
        min_time=time
        height=i
print(min_time,height)