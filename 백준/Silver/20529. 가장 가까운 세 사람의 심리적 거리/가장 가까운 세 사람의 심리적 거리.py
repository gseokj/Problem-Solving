import sys
input = sys.stdin.readline
for _ in range(int(input())):
    T = int(input())
    N = list(input().split())
    res = 9999999
    if T > 32:
        print(0)
    else:
        for i in range(T):
            for j in range(i+1, T-1):
                for k in range(j+1, T):
                    cnt = 0
                    for l in range(4):
                        if N[i][l] != N[j][l]:
                            cnt += 1
                        if N[i][l] != N[k][l]:
                            cnt += 1
                        if N[j][l] != N[k][l]:
                            cnt += 1
                    res = min(res, cnt)
        print(res)