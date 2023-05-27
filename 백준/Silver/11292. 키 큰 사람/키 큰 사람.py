from collections import Counter
while 1:
    n = int(input())
    if n == 0:
        break
    user = dict()
    user2=dict()
    tall = []
    for i in range(n):
        a, b = input().split()
        user[float(b)] = a
        user2[a] = float(b)
        tall.append(float(b))
    check = sorted(Counter(user2).most_common(),key=lambda x : -x[1])
    max_tall=0
    if check[0][1] != check[1][1]:
        print(user[max(tall)])
    else :
        max_tall=check[0][1]
        for i in range(len(check)):
            if check[i][1] == max_tall :
                print(check[i][0],end =' ')