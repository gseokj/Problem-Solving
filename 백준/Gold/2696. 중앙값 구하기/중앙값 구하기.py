for _ in range(int(input())):
    l = int(input())
    result = []
    a = []
    for _ in range((l-1)//10 + 1):
        a.extend(list(map(int, input().split())))
    print(l//2+1)
    cnt=0
    for i, j in enumerate(a):
        result.append(j)
        if i % 2 == 0:
            print(sorted(result)[len(result)//2], end=' ')
            if i%10 == 9:
                 print()
    print()
