mul = int(input()) * int(input()) * int(input())

for i in range(10):
    print(int(str(mul).count(str(i)))) # count 함수를 사용해서 문자열 속의 문자열을 찾은 후 int형을 print