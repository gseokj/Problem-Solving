import sys
input = sys.stdin.readline
T = int(input())
lis = []
for i in range(T):
    lis.append(int(input()))
lis.sort(reverse=True)
lis.insert(0,0)
print(sum([lis[i] for i in range(T+1) if i % 3]))