import heapq,sys
input = sys.stdin.readline
minheap = []
for i in range(int(input())):
    comm = int(input())
    if comm == 0 :
        if minheap:
            a,b = heapq.heappop(minheap)
            print(a*b)
        else :
            print(0)
    else :
        if comm > 0 :
            heapq.heappush(minheap,(comm,1))
        else :
            heapq.heappush(minheap, (abs(comm), -1))