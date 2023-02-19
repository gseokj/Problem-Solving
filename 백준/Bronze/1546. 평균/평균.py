T = int(input())
X = list(map(int,input().split()))
sum = 0
for i in X:
    sum+=i / max(X) * 100
    
print(sum/T)