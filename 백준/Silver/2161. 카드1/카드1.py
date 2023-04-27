from collections import deque
A = int(input())
card = [i+1 for i in range(A)]
deq = deque(card)
his=[]
while len(deq)>1 :
    his.append(deq.popleft())
    ta = deq.popleft()
    deq.append(ta)

his.append(deq[-1])
for i in his:
    print(i,end=' ')