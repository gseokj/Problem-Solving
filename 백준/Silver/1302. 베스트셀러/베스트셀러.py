from collections import Counter

lis = [input() for i in range(int(input()))]
comm = Counter(lis).most_common()
best_seller=[]

for i in comm :
    if comm[0][1]==i[1] :
        best_seller.append(i[0])
best_seller.sort()

print(best_seller[0])
