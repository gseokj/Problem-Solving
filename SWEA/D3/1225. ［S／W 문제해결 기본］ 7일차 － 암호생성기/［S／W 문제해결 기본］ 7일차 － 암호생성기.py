from collections import deque
for x in range(1,11):
    input()
    arr = list(map(int,input().split()))
    arr = deque(arr)
    flag = True
    while flag :
        for i in range(1,6) :
            a = arr.popleft() - i
            if a <= 0 :
                a = 0
                arr.append(a)
                flag = False
                break
            arr.append(a)

    print(f"#{x}",end=' ')
    print(*arr)