for x in range(1,int(input())+1):
    arr = list(map(int,input().split()))
    t_arr = sorted(arr)[1:-1]
    total = sum(t_arr)
    l = len(t_arr)
    print(f"#{x} {round(total/l)}")