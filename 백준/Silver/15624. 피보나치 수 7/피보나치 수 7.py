N = int(input())
a, b, c = 0, 1, 1
temp = 0

for i in range(N):
    temp = c
    a = b % 1000000007
    b = temp % 1000000007
    c = a + b

print(a)