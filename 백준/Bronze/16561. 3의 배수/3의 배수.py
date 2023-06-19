n = int(input());cnt = 0
for i in range(3, max(n-6, 0)+1, 3):
    for j in range(i+3, max(n-3, 0)+1, 3):
        cnt += 1
print(cnt)