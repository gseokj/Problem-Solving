while True:
    num = list(map(int, list(input())))
    if len(num) == 1 and num[0] == 0:
        break
    ans = 1 + len(num)
    for item in num:
        if item == 1:
            ans += 2
        elif item == 0:
            ans += 4
        else:
            ans += 3
    print(ans)