A, B = input().split()
if (int(A[::-1])>int(B[::-1])): # 문자열로 받아온 정수를 슬라이싱을 사용한 후 인트형으로 비교연산자를 사용한다.
    print(int(A[::-1]))
else :
    print(int(B[::-1]))
