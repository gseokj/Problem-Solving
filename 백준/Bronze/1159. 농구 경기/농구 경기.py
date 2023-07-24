n = int(input())
p = []
r = []

for _ in range(n):
    a = input()
    p.append(a[0])

f = set(p)

for i in f:
    if p.count(i) >= 5:
        r.append(i)

print(''.join(sorted(r))) if len(r) > 0 else print("PREDAJA")
