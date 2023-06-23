import sys
input = sys.stdin.readline
S = list(input().strip())
T = list(input().strip())
flag = False
while len(T) >0:
  if S == T:
    flag = True
    break
  if T.pop() == 'A':
    continue
  else:
    T = T[::-1]
print(1) if flag else print(0)