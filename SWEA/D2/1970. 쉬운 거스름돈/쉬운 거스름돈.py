


for x in range(1,int(input())+1):
    arr = {50000: 0, 10000: 0, 5000: 0, 1000: 0, 500: 0, 100: 0, 50: 0, 10: 0}
    T = int(input())
    for i in arr:
        while T - i >= 0 :
            T -= i
            arr[i] +=1
    print(f"#{x}")
    print(*arr.values())