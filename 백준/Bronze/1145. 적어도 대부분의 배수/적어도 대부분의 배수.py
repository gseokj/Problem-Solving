import sys
input = sys.stdin.readline
res = 0
arr = list(map(int,input().split()))
arr.sort()
for i in range(arr[2],100000001):
    is_true=0
    for j in range(5):
        if i % arr[j] == 0:
            is_true += 1
    if is_true > 2 :
        res = i
        break
print(res)