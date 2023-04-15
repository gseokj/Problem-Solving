
a,b = map(int,input().split()) # 카드의 개수, 최대한도
arr = list(map(int,input().split()))
result = 0
for i in range(a):
    for j in range(i+1, a):
        for k in range(j+1, a):
            
            if arr[i]+arr[j]+arr[k] > b :
                continue
            else :
                result = max(result,arr[i]+arr[j]+arr[k])
                
print(result)