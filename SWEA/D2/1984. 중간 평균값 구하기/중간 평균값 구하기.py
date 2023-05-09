for x in range(1,int(input())+1):
    arr = sorted(list(map(int,input().split())))[1:-1]
    print(f"#{x} {round(sum(arr)/len(arr))}")