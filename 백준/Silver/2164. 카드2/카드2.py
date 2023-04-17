from collections import deque
T = int(input())
test = deque([i for i in range(1,T+1)])

while len(test)!=1 :
    test.popleft()
    move = test.popleft()
    test.append(move)
print(test[0])
