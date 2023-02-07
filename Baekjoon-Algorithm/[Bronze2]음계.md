# 💡 음계

| 시간 제한 | 메모리 제한 | 제출    | 정답    | 맞힌 사람 | 정답 비율   |
| ----- | ------ | ----- | ----- | ----- | ------- |
| 1 초   | 128 MB | 82367 | 44991 | 38815 | 55.875% |

## 📃 문제

다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.

1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.

연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.

## 입력

첫째 줄에 8개 숫자가 주어진다. 이 숫자는 문제 설명에서 설명한 음이며, 1부터 8까지 숫자가 한 번씩 등장한다.

## 출력

첫째 줄에 ascending, descending, mixed 중 하나를 출력한다.

## 예제 입력 1

```
1 2 3 4 5 6 7 8
```

## 예제 출력 1

```
ascending
```

## 예제 입력 2

```
8 7 6 5 4 3 2 1
```

## 예제 출력 2

```
descending
```

## 예제 입력 3

```
8 1 7 2 6 3 5 4
```

## 예제 출력 3

```
mixed
```

## 알고리즘 분류

- [구현](https://www.acmicpc.net/problem/tag/102)

#### 🔑 Solution 1 🔑

```
A = list(map(int,input().split()))
cnt = 0
for i in range(0,2) :
     if A[i]<A[i+1] :
            cnt = cnt+1
     elif A[i]>A[i+1] :
            cnt = cnt-1
if cnt == 2 :
    print("ascending")
elif cnt == -2 :
    print("descending")
else :
    print("mixed")mixed")
```

![image](https://user-images.githubusercontent.com/116260619/217266056-d9505f35-9c0e-4672-a968-b4cd908eed49.png)

첫 시도는 reduce방식으로 앞 뒤 배열을 비교했는데 중간까지 맞다가 틀리는 것을 확인 할 수 있었는데 배열을 세 개만 비교하다보니 같은 숫자가 세 개 나왔을 때도 mixed를 출력하는 것 같았고, 굳이 반복문을 안 써도 될 것 같았다.

#### 🔑 Solution 2 🔑

```
A = list(map(int,input().split()))

if A==sorted(A):
    print("ascending")
elif A==sorted(A,reverse=True) :
    print("descending")
else :
    print("mixed")
```

sorted함수를 사용해서 받아본 배열이 같은지 확인해서 쉽게 구할 수 있었다.
