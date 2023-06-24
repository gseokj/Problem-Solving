from collections import deque
def bfs(S, T):
    C = 0
    q = deque()
    q.append([S, T, C])
    while q:
        s, t, c = q.popleft()
        if s < t:
            q.append([s * 2, t + 3, c + 1])
            q.append([s + 1, t, c + 1])
        elif s == t:
            print(c)
            break
for _ in range(int(input())):
    S, T = map(int, input().split())
    bfs(S, T)