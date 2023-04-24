n = int(input())

a_list = list(map(int, input().split()))
b_list = list(map(int, input().split()))

s = 0
for i in range(n):
    s += min(a_list) * max(b_list)
    a_list.pop(a_list.index(min(a_list)))
    b_list.pop(b_list.index(max(b_list)))

print(s)