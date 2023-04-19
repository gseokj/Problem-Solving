for _ in range(int(input())):
    A = int(input())
    cnt_z = [1, 0]
    cnt_o = [0, 1]
    for _ in range(2,A+1):
        cnt_z.append(cnt_o[-1])
        cnt_o.append(cnt_z[-2]+cnt_o[-1])
    print(cnt_z[A],cnt_o[A])