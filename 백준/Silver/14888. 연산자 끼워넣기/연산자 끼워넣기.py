from itertools import permutations

n = int(input())
numbers = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())
max_result = -int(1e9)
min_result = int(1e9)

def dfs(add_count, sub_count, mul_count, div_count, current_sum, current_index):
    global max_result, min_result
    if current_index == n:
        max_result = max(max_result, current_sum)
        min_result = min(min_result, current_sum)
        return
    if add_count:
        dfs(add_count-1, sub_count, mul_count, div_count, current_sum + numbers[current_index], current_index + 1)
    if sub_count:
        dfs(add_count, sub_count-1, mul_count, div_count, current_sum - numbers[current_index], current_index + 1)
    if mul_count:
        dfs(add_count, sub_count, mul_count-1, div_count, current_sum * numbers[current_index], current_index + 1)
    if div_count:
        dfs(add_count, sub_count, mul_count, div_count-1, int(current_sum / numbers[current_index]), current_index + 1)

dfs(add, sub, mul, div, numbers[0], 1)

print(max_result)
print(min_result)