import sys,heapq
input = sys.stdin.readline
for _ in range(int(input())):
    l= int(input())
    maxheap = []
    minheap = []
    v = [False] * l
    for i in range(l) :
        a, b=input().split()

        if a == "I":
            heapq.heappush(maxheap,(-int(b),i))
            heapq.heappush(minheap, (int(b), i))
            v[i] = True
        else :
            if b == "-1":
                while minheap and v[minheap[0][1]] == False:
                    heapq.heappop(minheap)
                if minheap:
                    v[minheap[0][1]]=False
                    heapq.heappop(minheap)
            else:
                while maxheap and v[maxheap[0][1]] == False:
                    heapq.heappop(maxheap)
                if maxheap:
                    v[maxheap[0][1]]=False
                    heapq.heappop(maxheap)
    if True not in v :
        print("EMPTY")
    else :
        while minheap and v[minheap[0][1]] == False:
            heapq.heappop(minheap)
        while maxheap and v[maxheap[0][1]] == False:
            heapq.heappop(maxheap)
        print(-maxheap[0][0],minheap[0][0])