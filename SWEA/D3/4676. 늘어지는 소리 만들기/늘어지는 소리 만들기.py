for x in range(int(input())):
    T = list(input())
    cnt = int(input())
    arr = sorted(list(map(int, input().split())),reverse=True)
    for i in range(cnt):
        T.insert(arr[i],"-")
    print(f"#{x+1}",''.join(T))