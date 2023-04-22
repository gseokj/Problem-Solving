import sys

input = sys.stdin.readline
from collections import Counter
# 산술평균 : N개의 수들의 합을 N으로 나눈 값
# 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
# 최빈값 : N개의 수들 중 가장 많이 나타나는 값
# 범위 : N개의 수들 중 최댓값과 최솟값의 차이
T = int(input())
lis = []
for _ in range(T):
    lis.append(int(input()))
total=sum(lis)
lis.sort()
# 산술 평균

print(int(round(total/T,0)))
# 중앙값
print(lis[T//2])
# 최빈값
c = Counter(lis).most_common()
if T>1 :
    if c[0][1] == c[1][1] :
        print (c[1][0])
    else :
        print(c[0][0])
else :
    print(c[0][0])
print(lis[-1]-lis[0])