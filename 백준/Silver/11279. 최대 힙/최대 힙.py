import heapq,sys
input = sys.stdin.readline
minheap = []
for i in range(int(input())):
    comm = int(input())
    if comm == 0 :
        if minheap:
            print(-heapq.heappop(minheap))
        else :
            print(0)
    else :
        heapq.heappush(minheap,-comm)