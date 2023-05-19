from collections import deque
for x in range(1,11):
    input()
    arr = input().split()
    input()
    c = deque(input().split())
    temp = []
    while c:
        c.popleft()
        seq = int(c.popleft())
        cnt = int(c.popleft())
        while cnt :
            cnt-=1
            temp.append(c.popleft())
        while temp:
            arr.insert(seq,temp.pop())
    print(f"#{x}",*arr[:10])


