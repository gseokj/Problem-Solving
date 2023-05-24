from collections import deque

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    priorities = list(map(int, input().split()))

    
    q = deque([(i, p) for i, p in enumerate(priorities)])
    count = 0
    while q:
        max_priority = max(q, key=lambda x: x[1])[1]
    
        doc = q.popleft()
        if doc[1] == max_priority:
            count += 1
            if doc[0] == m:
            
                print(count)
                break
        else:
            q.append(doc)
