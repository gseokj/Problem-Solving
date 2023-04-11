# 1. find함수 사용
# 2. 아스키코드를 사용

T = input()


# A="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
# for i in T:
#     print(A.find(i)+1,end = ' ') # 웹검색을 할 수 없는 경우(아스키코드를 모를때) find함수를 사용하여 비효율적 일 수 있음.

for i in T:
    print(ord(i)-64, end=' ')