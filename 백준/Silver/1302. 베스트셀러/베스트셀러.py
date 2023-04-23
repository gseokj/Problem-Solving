from collections import Counter
T = int(input())
lis = []
best_seller=[]
for i in range(T):
    lis.append(input())
comm = Counter(lis).most_common()
for i in comm :
    if comm[0][1]==i[1] :
        best_seller.append(i[0])
best_seller.sort()
print(best_seller[0])
