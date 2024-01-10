from itertools import permutations

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9]
answer = 0

for num in permutations(numbers, 3):
    isAnswer = True
    for i in range(n):
        if not isAnswer:
            break
        strike, ball = 0, 0
        for j in range(3):
            target = str(graph[i][0])
            if int(target[j]) == num[j]:
                strike += 1
            elif int(target[j]) in num:
                ball += 1
        if strike != graph[i][1] or ball != graph[i][2]:
            isAnswer = False
            break 
    if isAnswer:
        answer += 1

print(answer)