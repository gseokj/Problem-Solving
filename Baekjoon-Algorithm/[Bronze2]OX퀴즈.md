# 💡  OX퀴즈

| 시간 제한 | 메모리 제한 | 제출     | 정답    | 맞힌 사람 | 정답 비율   |
| ----- | ------ | ------ | ----- | ----- | ------- |
| 1 초   | 128 MB | 200825 | 99821 | 82132 | 49.781% |

## 📃 문제

"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.

"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.

OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

## 입력

첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.

## 출력

각 테스트 케이스마다 점수를 출력한다.

## 예제 입력 1

```
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX
```

## 예제 출력 1

```
10
9
7
55
30
```

## 알고리즘 분류

- [구현](https://www.acmicpc.net/problem/tag/102)
- [문자열](https://www.acmicpc.net/problem/tag/158)





#### 🔑 Solution 🔑

인트형 변수를 두 개 선언해주고 같은 문자열이 나오면 누적해주고 아니라면 초기화를 진행했다.

```
T = int(input())
for i in range(T):
 A = list(input())
 cnt = 0
 answer = 0
     for i in A:
         if i=='O':
             cnt+=1
             answer+=cnt
         else :
             cnt = 0
     print(answer)
```
