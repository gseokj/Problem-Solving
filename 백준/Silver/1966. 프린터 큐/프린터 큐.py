from collections import deque

# 입력값 받기
t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    priorities = list(map(int, input().split()))

    # 큐 생성
    q = deque([(i, p) for i, p in enumerate(priorities)])
    count = 0
    while q:
        # 큐에서 우선순위가 가장 높은 문서를 찾음
        max_priority = max(q, key=lambda x: x[1])[1]
        # 큐에서 문서를 꺼내 우선순위가 가장 높은 문서가 맨 앞으로 오도록 함
        doc = q.popleft()
        if doc[1] == max_priority:
            count += 1
            if doc[0] == m:
                # 출력될 문서의 인덱스를 찾음
                print(count)
                break
        else:
            q.append(doc)
