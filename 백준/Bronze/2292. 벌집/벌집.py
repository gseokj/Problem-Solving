n = int(input())
init = 1
cnt = 1

while n > init :
    init += 6 * cnt
    cnt += 1
print(cnt)