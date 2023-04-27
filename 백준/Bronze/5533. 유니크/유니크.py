N = int(input())
lis = [[],[],[]]
score = [0] * N
for i in range(N):
    T = list(map(int,input().split()))
    lis[0].append(T[0])
    lis[1].append(T[1])
    lis[2].append(T[2])
for i in range(3):
    for j in range(N):
        if lis[i].count(lis[i][j]) > 1 :
            score[j] += 0
        else :
            score[j] += lis[i][j]
for i in score:
    print(i)