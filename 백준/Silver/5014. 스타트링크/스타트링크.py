from collections import deque
import sys

def bfs(f, s, g, u, d):
    queue = deque([s])
    check = [0] * (f + 1)
    check[s] = 1

    while queue:
        y = queue.popleft()

        if y == g:
            return check[y] - 1
        else:
            for x in (y + u, y - d):
                if 0 < x <= f and check[x] == 0:
                    check[x] = check[y] + 1
                    queue.append(x)

    return "use the stairs"

if __name__ == "__main__":
    f, s, g, u, d = map(int, sys.stdin.readline().split())
    result = bfs(f, s, g, u, d)
    print(result)