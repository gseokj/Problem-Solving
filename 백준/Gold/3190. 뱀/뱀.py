import sys

n = int(input())
matrix = [[0] * n for _ in range(n)]
matrix[0][0] = 1
apples = int(input())
for i in range(apples):
    r, c = map(int, (input().split()))
    matrix[r - 1][c - 1] = 3
v = int(input())
v_time = []
v_list = []
for i in range(v):
    a, b = input().split()
    v_time.append(int(a))
    v_list.append(b)

dr = [0, 1, 0, -1]  # 90도로 돌기 오른쪽부터
dc = [1, 0, -1, 0]
time = 0
vector = 0
row = 0
col = 0
tail = 0
tails = [(0, 0)]
while True:
    time += 1
    row = row + dr[vector]
    col = col + dc[vector]

    if row >= n or col >= n or row < 0 or col < 0 or (row, col) in tails:
        break

    if matrix[row][col] == 3:
        matrix[row][col] = 0
        tail += 1
    else:
        tails.pop(0)

    tails.append((row, col))

    for i in range(v):
        if time == v_time[i]:
            if v_list[i] == "D":
                vector = (vector + 1) % 4
            else:
                vector = (vector - 1) % 4

print(time)
