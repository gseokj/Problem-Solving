from collections import deque,Counter


for _ in range(int(input())):
    T = int(input())
    deq = deque()
    for i in range(T):

        a=input().split()
        deq.append(a[1])
    result = 1
    for i in Counter(deq).most_common():
        result *= (i[1] + 1)
    print(result-1)
