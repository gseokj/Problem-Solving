from collections import deque
 
t = int(input())
 
for i in range(t):
    p = input()
    n = int(input())
    arr = input()[1:-1].split(',')
 
    arr_d = deque(arr)
 
    flag = 0
 
    if n == 0:
        arr_d = []
 
    for j in p:
        if j == 'R':
            flag += 1
        elif j == 'D':
            if len(arr_d) == 0:
                print("error")
                break
            else:
                if flag % 2 == 0:
                    arr_d.popleft()
                else:
                    arr_d.pop()
 
    else:
        if flag % 2 == 0:
            print("[" + ",".join(arr_d) + "]")
        else:
            arr_d.reverse()
            print("[" + ",".join(arr_d) + "]")