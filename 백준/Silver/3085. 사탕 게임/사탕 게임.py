n = int(input())

a = [list(map(str, input())) for _ in range(n)]

m = 0

def c(line):
    global m
    
    cnt = 1
    for i in range(len(line) - 1):
        if line[i] == line[i + 1]:
            cnt += 1
            m = max(m, cnt)
        else:
            cnt = 1

def calc():
    global m

    for i in range(n):
        c(a[i])
        c([a[j][i] for j in range(n)])

for i in range(n):
    for j in range(n - 1):
        if a[i][j] != a[i][j + 1]:
            a[i][j], a[i][j + 1] = a[i][j + 1], a[i][j]
            calc()
            a[i][j + 1], a[i][j] = a[i][j], a[i][j + 1]

        if a[j][i] != a[j + 1][i]:
            a[j][i], a[j + 1][i] = a[j + 1][i], a[j][i]
            calc()
            a[j + 1][i], a[j][i] = a[j][i], a[j + 1][i]

print(m)