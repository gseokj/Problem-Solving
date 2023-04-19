from collections import deque

N,K = map(int,input().split())

deq = deque([i for i in range(1,N+1)])

result =[]

for _ in range(N) :
    deq.rotate(-K)
    result.append(deq.pop())
    
print('<'+str(result)[1:-1]+'>')
