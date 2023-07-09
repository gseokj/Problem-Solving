n,m = map(int, input().split())
a = list(map(int, input().split()))
for i in a:
    print(i - n * m, end = ' ')