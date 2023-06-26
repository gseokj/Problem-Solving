from itertools import permutations
n, m = map(int, input().split())
nums = [i for i in range(1, n+1)]
for i in permutations(nums, m):
    print(' '.join(map(str,i)))