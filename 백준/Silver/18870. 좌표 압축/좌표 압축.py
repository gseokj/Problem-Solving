N=int(input())
arr = list(map(int,input().split()))
arr_sort = sorted(set(arr))
res = {arr_sort[i] : i for i in range(len(arr_sort))}
for i in range(len(arr)):
    print(res[arr[i]], end=' ')