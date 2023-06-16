import sys
input = sys.stdin.readline
T = int(input())
for i in range(T):
    B, D = input().split()
    B = int(B)
    temp=0
    temp = sum(map(int,list(D)))
    print(temp%(B-1))