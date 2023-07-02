import sys
input = sys.stdin.readline
for _ in range(3):
    total = 0
    for _ in range(int(input())):
        total += int(input())
    if total > 0:
        print("+")
    else :
        print(str(total)[0])