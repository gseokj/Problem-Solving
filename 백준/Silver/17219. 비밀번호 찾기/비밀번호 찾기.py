n,m = map(int,input().split())
a=dict()
for _ in range(n):
    site,pw = input().split()
    a[site] = pw
for _ in range(m):
    site = input()
    print(a[site])