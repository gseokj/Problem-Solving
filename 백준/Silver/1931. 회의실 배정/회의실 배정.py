arr = [list(map(int,input().split())) for _ in range(int(input()))]
l = len(arr)
for i in range(l):
    arr[i].append(arr[i][1]-arr[i][0])
arr.sort(key=lambda x:(x[1],x[0]))
res=[arr[0]]
for i in range(1,l):
    if res[-1][1] <= arr[i][0] :
        res.append(arr[i])
print(len(res))