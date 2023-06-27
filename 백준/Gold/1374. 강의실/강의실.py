import sys
import heapq
input = sys.stdin.readline
arr = []
T = int(input())
for _ in range(T):
    n, s, e = map(int, input().split())
    arr.append([s, e])
arr.sort(key=lambda x: x[0])
heap = []
cnt = 0
for i in arr:
    if heap and heap[0] <= i[0]:
        heapq.heappop(heap)
    heapq.heappush(heap, i[1])
    cnt = max(cnt, len(heap))
print(cnt)