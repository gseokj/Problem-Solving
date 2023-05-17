for x in range(1, int(input()) + 1):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))
    result = [i for i in range(1, n + 1) if i not in arr]
    print(f"#{x} {' '.join(map(str,result))}")